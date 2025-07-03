package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.custom_repositories.CustomOrderRepository;

public interface OrderRepository extends JpaRepository<Order,Long>, CustomOrderRepository {
    
}
