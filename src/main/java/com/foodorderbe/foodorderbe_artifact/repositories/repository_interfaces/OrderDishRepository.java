package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderbe.foodorderbe_artifact.entities.OrderDish;
import com.foodorderbe.foodorderbe_artifact.entities.OrderDishKey;

public interface OrderDishRepository extends JpaRepository<OrderDish, OrderDishKey>, CustomOrderDishRepository{
    
}
