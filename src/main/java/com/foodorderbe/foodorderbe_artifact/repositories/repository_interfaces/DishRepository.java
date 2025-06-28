package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import com.foodorderbe.foodorderbe_artifact.entities.Dish;

public interface DishRepository extends JpaRepository<Dish, Long>{
} 