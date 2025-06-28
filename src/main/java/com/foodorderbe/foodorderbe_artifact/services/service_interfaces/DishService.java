package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import java.util.List;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;

public interface DishService {

    List<Dish> getAllDishs();

    User getDishUser(Long dishId);

}