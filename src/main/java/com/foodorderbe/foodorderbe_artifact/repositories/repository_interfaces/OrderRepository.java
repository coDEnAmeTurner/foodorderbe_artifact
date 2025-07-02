package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderbe.foodorderbe_artifact.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long> {
    
}
