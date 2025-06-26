package com.foodorderbe.foodorderbe_artifact.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.repositories.DishRepository;

@Service
public class DishService {
    @Autowired
    private DishRepository dishRepository;

    public List<Dish> getAllDishs() {
        return dishRepository.findAll();
    }
}
