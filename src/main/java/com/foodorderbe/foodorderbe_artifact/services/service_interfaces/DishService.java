package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;
import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;

public interface DishService {

        List<Dish> getAllDishs(
                        Long shopId,
                        String name,
                        float fromPrice,
                        float toPrice,
                        boolean available,
                        String daySession);

        Dish getDish(Long dishId);

        User getDishUser(Long dishId);

        Dish destroyDish(Long dishId);

        Dish createOrUpdateDish(Long dishId,
                        String description,
                        String daySession,
                        boolean isAvailable,
                        float price,
                        String name,
                        MultipartFile file);

        List<Comment> getComments(Long dishId);
}