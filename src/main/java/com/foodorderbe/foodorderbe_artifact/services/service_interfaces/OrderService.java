package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import java.util.List;

import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.requests.ItemOrderCreateOrUpdateReq;

public interface OrderService {

    Order createOrUpdateOrderDishs(
        Long orderId,
        User user,
        List<ItemOrderCreateOrUpdateReq> items,
        String purchaseType,
        String shipAddress
    );

    Order createOrUpdateOrderMenus(
        Long orderId,
        User user,
        List<ItemOrderCreateOrUpdateReq> items,
        String purchaseType,
        String shipAddress
    );

    void deleteOrder(Long orderId);
    Order getOrder(Long orderId);
    Order verifyOrder(Long orderId);
    double calculateTotalPriceByOrderId(Long orderId);
} 
