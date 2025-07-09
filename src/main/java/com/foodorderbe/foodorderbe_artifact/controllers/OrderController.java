package com.foodorderbe.foodorderbe_artifact.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.exceptions.OrderNotFoundException;
import com.foodorderbe.foodorderbe_artifact.requests.OrderCreateOrUpdateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.OrderService;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.UserService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/Orders")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @ExceptionHandler(NoSuchElementException.class)
    @ResponseBody
    public ResponseEntity< Map<String, String>> noOrder(HttpServletRequest req, Exception ex) {
        var map = new HashMap<String,String>();
        var resp = new ResponseEntity<Map<String,String>>(map,HttpStatus.NOT_FOUND);

        if (ex instanceof OrderNotFoundException) {
            map.put("msg", ex.getMessage());
            return resp;
        }
        map.put("msg","No such element");
        return resp;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity< Map<String, String>> reqViolation(HttpServletRequest req, Exception ex) {
        var map = new HashMap<String,String>();
        var resp = new ResponseEntity<Map<String,String>>(map,HttpStatus.BAD_REQUEST);

        if (ex instanceof MethodArgumentNotValidException) {
            var errors = ((MethodArgumentNotValidException)ex).getAllErrors();
            map.put("msg", errors.get(errors.size() - 1).getDefaultMessage());
            return resp;
        }
        map.put("msg","Your request is tampered!");
        return resp;
    }

    @RequestMapping(value = { "/Dishs/", "/{id}/Dishs/" }, method = { RequestMethod.POST, RequestMethod.PUT,
            RequestMethod.PATCH })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Order> createOrUpdateOrderDishs(@PathVariable(name = "id") Optional<Long> orderId,
            @RequestBody @Valid OrderCreateOrUpdateReq req) {
        // userid should be from jwt token
        User user = userService.getUser(1L);
        var order = orderService.createOrUpdateOrderDishs(orderId.isPresent() ? orderId.get() : 0, user, req.getItems(),
                req.getPurchaseType(), req.getShipAddress());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @RequestMapping(value = { "/Menus/", "/{id}/Menus/" }, method = { RequestMethod.POST, RequestMethod.PUT,
            RequestMethod.PATCH })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Order> createOrUpdateOrderMenus(@PathVariable(name = "id") Optional<Long> orderId,
            @RequestBody OrderCreateOrUpdateReq req) {
        // userid should be from jwt token
        var order = orderService.createOrUpdateOrderMenus(orderId.isPresent() ? orderId.get() : 0,
                userService.getUser(1L), req.getItems(), req.getPurchaseType(), req.getShipAddress());
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @CrossOrigin
    public ResponseEntity deleteOrder(@PathVariable(name = "id") Long orderId) {
        orderService.deleteOrder(orderId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Order> getOrder(@PathVariable(name = "id") Long orderId) {
        var order = orderService.getOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}/calcTotal")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Float> calculateTotal(@PathVariable(name = "id") Long orderId) {
        var order = orderService.calculateTotalPriceByOrderId(orderId);
        return new ResponseEntity<>((float)order, HttpStatus.OK);
    }

    @PatchMapping(path = "/{id}/verify")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Order> verifyOrder(@PathVariable(name = "id") Long orderId) {
        var order = orderService.verifyOrder(orderId);
        return new ResponseEntity<>(order, HttpStatus.OK);
    }
}
