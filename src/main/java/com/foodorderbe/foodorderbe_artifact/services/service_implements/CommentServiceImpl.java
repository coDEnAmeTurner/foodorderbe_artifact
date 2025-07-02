package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;
import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.entities.Order;
import com.foodorderbe.foodorderbe_artifact.entities.OrderMenu;
import com.foodorderbe.foodorderbe_artifact.entities.OrderMenuKey;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.CommentRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.DishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.ShopRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.UserRepository;
import com.foodorderbe.foodorderbe_artifact.requests.CommentCreateOrUpdateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    DishRepository dishRepository;
    @Autowired
    ShopRepository shopRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Comment createOrUpdateComment(String content, Long parentId, Long dishId, Long shopId, User user,
            Long commentId) {
        Comment comment;
        if (commentId != 0)
            comment = commentRepository.findById(commentId).get();
        else
            comment = new Comment();

        if (parentId != 0)
            comment.setParent(getComment(parentId));

        if (dishId != 0)
            comment.setDish(dishRepository.findById(dishId).get());

        if (shopId != 0)
            comment.setShop(shopRepository.findById(shopId).get());

        comment.setContent(content);
        comment.setUser(user);
        commentRepository.save(comment);

        return comment;
    }

    @Override
    public Comment getComment(Long commentId) {
        return commentRepository.findById(commentId).get();
    }

    @Override
    public Set<Comment> getChildren(Long commentId) {
        var c = getComment(commentId);
        var set = c.getChildren();
        return set;
    }

}
