package com.foodorderbe.foodorderbe_artifact.repositories.repository_implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;
import com.foodorderbe.foodorderbe_artifact.entities.OrderMenu;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.CustomOrderDishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.CustomOrderMenuRepository;

import jakarta.transaction.Transactional;

@Repository
public class OrderMenuRepositoryImpl implements CustomOrderMenuRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    @Transactional
    public void deleteOrderMenuByOrderId(Long orderId) {
        var session = sessionFactory.getObject().getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var cquery = builder.createCriteriaDelete(OrderMenu.class);
        var root = cquery.from(OrderMenu.class);
        cquery.where(builder.equal(root.get("order").get("id"), orderId));

        session.createQuery(cquery).executeUpdate();
    }
    
}
