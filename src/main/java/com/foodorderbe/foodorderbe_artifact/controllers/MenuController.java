package com.foodorderbe.foodorderbe_artifact.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.requests.DishUpdateReq;
import com.foodorderbe.foodorderbe_artifact.requests.MenuCreateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.MenuService;

@RestController
@RequestMapping("/Menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @PutMapping(path = "/{id}", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @PostMapping(path = "/", consumes = {
            MediaType.APPLICATION_JSON_VALUE
    }, produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Menu> createOrUpdateMenu(@PathVariable(name = "id") Optional<Long> menuId,
            @RequestBody MenuCreateReq req) {
                System.out.println(menuId.get());
        var menu = menuService.createOrUpdateMenu(menuId.isPresent()?menuId.get():0, req.getName(), req.getShopId(), req.getDishs());
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }
}
