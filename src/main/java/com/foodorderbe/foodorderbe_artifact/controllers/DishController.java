package com.foodorderbe.foodorderbe_artifact.controllers;

import java.util.List;

import javax.print.attribute.standard.Media;

import org.apache.http.entity.ContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;
import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.requests.DishGetAllReq;
import com.foodorderbe.foodorderbe_artifact.requests.DishUpdateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_implements.DishServiceImpl;

@RestController
@RequestMapping(path = "/Dishs")
public class DishController {

    @Autowired
    private DishServiceImpl dishService;

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<List<Dish>> getAllDishs(@RequestBody DishGetAllReq req) {
        return new ResponseEntity<List<Dish>>(dishService.getAllDishs(
                req.getShopId(),
                req.getName(),
                req.getFromPrice(),
                req.getToPrice(),
                req.isAvailable(),
                req.getDaySession()), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/getUser")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<User> getDishUser(@PathVariable(name = "id") Long dishId) {
        return new ResponseEntity<>(dishService.getDishUser(dishId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public ResponseEntity<Dish> destroyDish(@PathVariable(name = "id") Long dishId) {
        return new ResponseEntity<>(dishService.destroyDish(dishId), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Dish> getDish(@PathVariable(name = "id") Long dishId) {
        return new ResponseEntity<>(dishService.getDish(dishId), HttpStatus.OK);
    }

    @PostMapping(path = "/", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @PutMapping(path = "/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Dish> createOrUpdateDish(@PathVariable(name = "id", required = false) Long dishId,
            @RequestPart(name = "req") DishUpdateReq req, @RequestPart(name = "file") MultipartFile[] file) {
        var dish = dishService.createOrUpdateDish(dishId,
                req.getDescription(),
                req.getDaySession(),
                req.isAvailable(),
                req.getPrice(),
                req.getName(),
                file[0]);
        return new ResponseEntity<>(dish, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}/Comments/")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<List<Comment>> getComments(@PathVariable(name = "id") Long dishId) {
        return new ResponseEntity<List<Comment>>(dishService.getComments(dishId), HttpStatus.OK);
    }
}
