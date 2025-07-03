package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.io.IOException;
import java.lang.StackWalker.Option;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.foodorderbe.foodorderbe_artifact.entities.Comment;
import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.CommentRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.DishRepository;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.DishService;
import com.foodorderbe.foodorderbe_artifact.specifications.CommentSpecs;
import com.foodorderbe.foodorderbe_artifact.specifications.DishSpecs;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishRepository dishRepository;
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    public Cloudinary cloudinary;

    @Override
    public List<Dish> getAllDishs(
            Long shopId,
            String name,
            float fromPrice,
            float toPrice,
            boolean available,
            String daySession) {
        return dishRepository.findAll(
                DishSpecs
                        .isOfShop(shopId)
                        .and(DishSpecs.containsName(name))
                        .and(DishSpecs.fromToPrice(fromPrice, toPrice))
                        .and(DishSpecs.isAvailable(available))
                        .and(DishSpecs.equalsDaySession(daySession))
                        );
    }

    @Override
    public User getDishUser(Long dishId) {
        Optional<Dish> d = dishRepository.findById(dishId);
        if (!d.isPresent())
            return null;

        return d.get().getShop().getUser();

    }

    @Override
    public Dish destroyDish(Long dishId) {
        var opDish = dishRepository.findById(dishId);
        if (!opDish.isPresent())
            return null;

        dishRepository.deleteById(dishId);
        return opDish.get();
    }

    @Override
    public Dish createOrUpdateDish(Long dishId, String description, String daySession, boolean isAvailable, float price,
            String name, MultipartFile file) {
        var opDish = dishRepository.findById(dishId);
        if (!opDish.isPresent())
            return null;

        var d = opDish.get();
        d.setAvailable(isAvailable);
        d.setDaySession(daySession);
        d.setDescription(description);
        d.setName(name);
        d.setPrice(price);

        if (!file.isEmpty()) {
            try {
                Map res = this.cloudinary.uploader().upload(file.getBytes(),
                        ObjectUtils.asMap("resource_type", "auto"));
                d.setPicture(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(DishService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        dishRepository.save(d);
        return d;
    }

    @Override
    public Dish getDish(Long dishId) {
        var opDish = dishRepository.findById(dishId);
        if (!opDish.isPresent())
            return null;

        return opDish.get();
    }

    @Override
    public List<Comment> getComments(Long dishId) {
        return commentRepository.findAll(CommentSpecs.isOfDish(dishId));
    }
}
