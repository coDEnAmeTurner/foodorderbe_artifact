package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderbe.foodorderbe_artifact.entities.OrderMenu;
import com.foodorderbe.foodorderbe_artifact.entities.OrderMenuKey;

public interface OrderMenuRepository extends JpaRepository<OrderMenu, OrderMenuKey>, CustomOrderMenuRepository{
    
}
