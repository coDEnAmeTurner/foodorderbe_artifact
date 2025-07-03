package com.foodorderbe.foodorderbe_artifact.entities.metamodels;

import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(Order.class)
public class Order_ {
    public static volatile SingularAttribute<Order, OrderDish> orderDishs;
    
}
