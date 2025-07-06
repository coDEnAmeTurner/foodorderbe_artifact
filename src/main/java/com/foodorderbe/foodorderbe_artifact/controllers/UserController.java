package com.foodorderbe.foodorderbe_artifact.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.MediaType;
import org.springframework.http.HttpStatus;
import java.util.HashMap;
import java.util.Map;
import javax.naming.AuthenticationException;

import java.text.ParseException;

import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.requests.LoginRequest;
import com.foodorderbe.foodorderbe_artifact.requests.UserCreateReq;
import com.foodorderbe.foodorderbe_artifact.responses.LoginResp;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.LoginService;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.UserService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(path = "/Users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    LoginService loginService;

    @ExceptionHandler(AuthenticationException.class)
    @ResponseBody
    public ResponseEntity< Map<String, String>> authenFailed(HttpServletRequest req, Exception ex) {
        var map = new HashMap<String,String>();
        var resp = new ResponseEntity<Map<String,String>>(map,HttpStatus.UNAUTHORIZED);

        if (ex instanceof AuthenticationException) {
            map.put("msg", ex.getMessage());
            return resp;
        }
        map.put("msg","Authentication failed");
        return resp;
    }

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

    @PostMapping(path = "/login", consumes = {
            MediaType.APPLICATION_JSON_VALUE,
    }, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<LoginResp> login(@RequestBody LoginRequest req) {
        return new ResponseEntity<>(loginService.authenticateByUserNamePassword(req.getUserName(), req.getPassword()), HttpStatus.OK);
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
