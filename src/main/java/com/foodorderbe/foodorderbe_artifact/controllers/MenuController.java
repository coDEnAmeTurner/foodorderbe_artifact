package com.foodorderbe.foodorderbe_artifact.controllers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.foodorderbe.foodorderbe_artifact.entities.Dish;
import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.requests.MenuCreateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.MenuService;

@RestController
@RequestMapping("/Menus")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping(
        value = {"/", "/{id}"}, 
        consumes = {MediaType.APPLICATION_JSON_VALUE}, 
        produces = { MediaType.APPLICATION_JSON_VALUE }, 
        method = {RequestMethod.POST, RequestMethod.PUT})
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Menu> createOrUpdateMenu(@PathVariable(name = "id") Optional<Long> menuId,
            @RequestBody MenuCreateReq req) {
        var menu = menuService.createOrUpdateMenu(menuId.isPresent()?menuId.get():0, req.getName(), req.getShopId(), req.getDishs());
        return new ResponseEntity<>(menu, HttpStatus.CREATED);
    }

    @GetMapping(path = "")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<List<Menu>> getAllMenus(@RequestParam Map<String,String> params) {
        var shopId = params.get("shopId");
        var name = params.get("name");

        var pShopId = shopId == null?0:Long.parseLong(shopId);
        var pName = name==null?"":name;

        return new ResponseEntity<>( menuService.getAllMenus(pShopId, pName), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Menu> getMenu(@PathVariable(name = "id") Long menuId) {
        return new ResponseEntity<>(menuService.getMenuById(menuId), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}/Dishs/{dishId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public ResponseEntity removeDish(@PathVariable(name = "id") Long menuId, @PathVariable(name = "dishId") Long dishId) {
        menuService.removeDish(menuId, dishId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
