package com.foodorderbe.foodorderbe_artifact.controllers;

import org.apache.http.protocol.HTTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import java.util.HashMap;
import java.util.Map;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.ParseException;

import com.foodorderbe.foodorderbe_artifact.entities.Shop;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.requests.UserCreateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.UserService;

@RestController
@RequestMapping(path = "/Users")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(path = "/", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    }, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Object> create(@RequestParam Map<String, String> params, @RequestPart MultipartFile[] file)
            throws ParseException {
                var u = userService.createUser(
                        params.get("password"),
                        params.get("email"),
                        params.get("lastName"),
                        params.get("firstName"),
                        params.get("userName"),
                        params.get("type"),
                        params.get("phone"),
                        params.get("name"),
                        file[0]);
                return new ResponseEntity<>(u,HttpStatus.CREATED);
    }

    @PostMapping(path = "/WithObj/", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.MULTIPART_FORM_DATA_VALUE
    }, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    //use @RequestBody if theres no file
    public ResponseEntity<User> createWithObj(@RequestPart(value = "req") UserCreateReq req, 
    @RequestPart(value = "file") MultipartFile[] file)
            throws ParseException {
                var u = userService.createUser(
                        req.getPassword(),
                        req.getEmail(),
                        req.getLastName(),
                        req.getFirstName(),
                        req.getUserName(),
                        req.getType(),
                        req.getPhone(),
                        req.getName(),
                        file[0]);
                return new ResponseEntity<>(u,HttpStatus.CREATED);
    }
}
