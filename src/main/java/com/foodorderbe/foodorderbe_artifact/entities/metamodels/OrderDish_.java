package com.foodorderbe.foodorderbe_artifact.entities.metamodels;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;

@StaticMetamodel(OrderDish.class)
public class OrderDish_ {
    public static volatile SingularAttribute<OrderDish, Order> order;
    public static volatile SingularAttribute<OrderDish, Dish> dish;
    public static volatile SingularAttribute<OrderDish, Integer> count;

}
