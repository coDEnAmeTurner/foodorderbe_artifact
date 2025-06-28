package com.foodorderbe.foodorderbe_artifact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.foodorderbe.foodorderbe_artifact.responses.ShopResp;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.ShopService;

@RestController
@RequestMapping("/Shops")
public class ShopController {
    @Autowired
    ShopService shopService;

    @PatchMapping(path = "/{id}/verifyShop")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<ShopResp> verifyShop(@PathVariable(name = "id") Long shopId){
        var resp = shopService.verifyShop(shopId);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<ShopResp> getShop(@PathVariable(name = "id") Long shopId){
        var resp = shopService.getShop(shopId);
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }


}
