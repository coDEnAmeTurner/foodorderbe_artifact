package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDishKey;
import com.foodorderbe.foodorderbe_artifact.entities.OrderMenu;
import com.foodorderbe.foodorderbe_artifact.entities.OrderMenuKey;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.exceptions.OrderNotFoundException;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.DishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.MenuRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.OrderDishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.OrderMenuRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.OrderRepository;
import com.foodorderbe.foodorderbe_artifact.requests.ItemOrderCreateOrUpdateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private OrderDishRepository orderDishRepository;
    @Autowired
    private OrderMenuRepository orderMenuRepository;

    @Override
    public Order createOrUpdateOrderDishs(Long orderId, User user, List<ItemOrderCreateOrUpdateReq> items,
            String purchaseType,
            String shipAddress) {
        Order order;
        try {
            if (orderId != 0)
                order = orderRepository.findById(orderId).get();
            else
                order = new Order();

        } catch (NoSuchElementException ex) {
            throw new OrderNotFoundException("OrderId not found!");
        }
        order.setUser(user);
        if (!purchaseType.isEmpty())
            order.setPaymentType(purchaseType);
        if (!shipAddress.isEmpty())
            order.setShipAddress(shipAddress);
        orderRepository.save(order);

        if (orderId != 0)
            orderDishRepository.deleteOrderDishByOrderId(orderId);

        if (!items.isEmpty())
            items.forEach(item -> {
                OrderDish orderDish = new OrderDish();
                OrderDishKey key = new OrderDishKey();
                key.setDishId(item.getItemId());
                key.setOrderId(order.getId());
                orderDish.setId(key);

                try {

                    Dish d = dishRepository.findById(item.getItemId()).get();
                    orderDish.setDish(d);
                    orderDish.setOrder(order);

                    orderDish.setCount(item.getCount());
                    orderDish.setSideNote(item.getNote());
                    orderDishRepository.save(orderDish);
                } catch (NoSuchElementException e) {
                    throw new OrderNotFoundException(String.format("Dish id %d not found", item.getItemId()));
                }
            });
        
        return order;
    }

    @Override
    public Order createOrUpdateOrderMenus(Long orderId, User user, List<ItemOrderCreateOrUpdateReq> items,
            String purchaseType,
            String shipAddress) {
        Order order;
        if (orderId != 0)
            order = orderRepository.findById(orderId).get();
        else
            order = new Order();
        order.setUser(user);
        order.setPaymentType(purchaseType);
        order.setShipAddress(shipAddress);
        orderRepository.save(order);

        if (orderId != 0)
            orderMenuRepository.deleteOrderMenuByOrderId(orderId);

        items.forEach(item -> {
            OrderMenu orderMenu = new OrderMenu();
            OrderMenuKey key = new OrderMenuKey();
            key.setMenuId(item.getItemId());
            key.setOrderId(order.getId());
            orderMenu.setId(key);

            Menu m = menuRepository.findById(item.getItemId()).get();
            orderMenu.setMenu(m);
            orderMenu.setOrder(order);

            orderMenu.setCount(item.getCount());
            orderMenu.setSideNote(item.getNote());
            orderMenuRepository.save(orderMenu);

        });

        var total = orderRepository.calculateTotalPriceByOrderId(order);
        order.setTotalPrice((float)total);
        orderRepository.save(order);
        
        return order;
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderDishRepository.deleteOrderDishByOrderId(orderId);
        orderMenuRepository.deleteOrderMenuByOrderId(orderId);
        orderRepository.deleteById(orderId);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).get();
    }

    @Override
    public Order verifyOrder(Long orderId) {
        var order = orderRepository.findById(orderId).get();
        order.setValid(true);
        orderRepository.save(order);
        return order;
    }

    @Override
    public double calculateTotalPriceByOrderId(Long orderId) {
        var order =  orderRepository.findById(orderId).get();   
        return orderRepository.calculateTotalPriceByOrderId(order);
    }
}
