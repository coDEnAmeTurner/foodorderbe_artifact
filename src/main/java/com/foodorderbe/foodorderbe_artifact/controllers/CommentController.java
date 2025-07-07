package com.foodorderbe.foodorderbe_artifact.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.antlr.v4.runtime.CommonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.requests.CommentCreateOrUpdateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.CommentService;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.UserService;

@RestController
@RequestMapping("/Comments")
public class CommentController {
    @Autowired
    CommentService commentService;
    @Autowired
    UserService userService;

    @RequestMapping(value = { "/", "/{id}" }, method = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH })
    @ResponseStatus(HttpStatus.CREATED)
    @CrossOrigin
    public ResponseEntity<Comment> createOrUpdateComment(@PathVariable(name = "id") Optional<Long> commentId,
            @RequestBody CommentCreateOrUpdateReq req) {
        //fetch userId by jwt token
        User user = userService.getUser(1L);
        Comment c = commentService.createOrUpdateComment(req.getContent(), req.getParentId(), req.getDishId(),
                req.getShopId(), user, commentId.isPresent() ? commentId.get() : 0);
        return new ResponseEntity<Comment>(c, HttpStatus.CREATED);
    }

    @GetMapping(path = "/{id}/getChildren")
    @ResponseStatus(HttpStatus.OK)
    @CrossOrigin
    public ResponseEntity<Set<Comment>> getChildren(@PathVariable(name = "id") Long commentId) {
        Set<Comment> c = commentService.getChildren(commentId);
        return new ResponseEntity< Set<Comment>>(c, HttpStatus.CREATED);
    }
}
