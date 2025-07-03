package com.foodorderbe.foodorderbe_artifact.repositories.repository_implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.custom_repositories.CustomOrderDishRepository;

import jakarta.transaction.Transactional;

@Repository
public class OrderDishRepositoryImpl implements CustomOrderDishRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public void deleteOrderDishByOrderId(Long orderId) {
        var session = sessionFactory.getObject().getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var cquery = builder.createCriteriaDelete(OrderDish.class);
        var root = cquery.from(OrderDish.class);
        cquery.where(builder.equal(root.get("order").get("id"), orderId));

        session.createQuery(cquery).executeUpdate();
    }
    
}
