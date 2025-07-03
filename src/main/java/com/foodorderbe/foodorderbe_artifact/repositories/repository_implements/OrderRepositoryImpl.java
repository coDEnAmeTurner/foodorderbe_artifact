package com.foodorderbe.foodorderbe_artifact.repositories.repository_implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDish_;
import com.foodorderbe.foodorderbe_artifact.entities.Order_;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.custom_repositories.CustomOrderRepository;

import jakarta.persistence.criteria.Join;
import jakarta.transaction.Transactional;

@Repository
public class OrderRepositoryImpl implements CustomOrderRepository{

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public double calculateTotalPriceByOrderId(Order order) {
        var session  = sessionFactory.getObject().getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var cq = builder.createQuery(Object[].class);
        var rootOD  = cq.from(OrderDish.class);
        Join<OrderDish,Dish> odjoin = rootOD.join("dish");
        Join<OrderDish,Order> oojoin = rootOD.join("order");
        cq.multiselect(builder.sum(builder.prod(builder.prod( odjoin.get("price"), rootOD.get("count")), oojoin.get("shipPayment"))))
            .where(builder.equal(rootOD.get("order"), order));
        var rslt = session.createQuery(cq).getResultList();
        var first = rslt.get(0)[0].toString();
        return Double.parseDouble(first);
    }
    
}
