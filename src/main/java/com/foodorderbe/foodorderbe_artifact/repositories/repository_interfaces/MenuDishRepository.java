package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodorderbe.foodorderbe_artifact.entities.MenuDish;
import com.foodorderbe.foodorderbe_artifact.entities.MenuDishKey;

public interface MenuDishRepository extends JpaRepository<MenuDish, MenuDishKey>, CustomMenuDishRepository {
}
