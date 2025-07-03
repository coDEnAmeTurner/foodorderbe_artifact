package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.custom_repositories;

import com.foodorderbe.foodorderbe_artifact.entities.Order;

public interface CustomOrderRepository {
    double calculateTotalPriceByOrderId(Order order);
}
