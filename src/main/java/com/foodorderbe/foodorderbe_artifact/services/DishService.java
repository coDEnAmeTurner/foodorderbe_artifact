package com.foodorderbe.foodorderbe_artifact.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.repositories.DishRepository;


@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishs() {
        return dishRepository.findAll();
    }

    @Transactional
    public User getDishUser(Long dishId) {
        Optional<Dish> d = dishRepository.findById(dishId);
        if (!d.isPresent())
            return null;

        return d.get().getShop().getUser();

    }
}
