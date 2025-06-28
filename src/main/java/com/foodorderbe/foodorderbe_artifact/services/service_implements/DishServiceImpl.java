package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.DishRepository;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.DishService;


@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;

    @Override
    public List<Dish> getAllDishs() {
        return dishRepository.findAll();
    }

    @Override
    public User getDishUser(Long dishId) {
        Optional<Dish> d = dishRepository.findById(dishId);
        if (!d.isPresent())
            return null;

        return d.get().getShop().getUser();

    }
}
