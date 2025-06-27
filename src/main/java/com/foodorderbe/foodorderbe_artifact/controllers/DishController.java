package com.foodorderbe.foodorderbe_artifact.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.services.DishService;

@RestController
@RequestMapping(path = "/Dishs")
public class DishController {
    
    @Autowired
    private DishService dishService;

    @GetMapping(path = "")
    public @ResponseBody List<Dish> getAllDishs() {
        return dishService.getAllDishs();
    }

    @GetMapping(path = "/{id}/getUser")
    public @ResponseBody User getFirstDishUser(@PathVariable(name = "id") Long dishId) {
        return dishService.getDishUser(dishId);
    }
}
