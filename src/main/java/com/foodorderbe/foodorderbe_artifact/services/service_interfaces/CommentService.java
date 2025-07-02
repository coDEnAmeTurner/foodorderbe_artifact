package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import java.util.List;
import java.util.Set;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;
import com.foodorderbe.foodorderbe_artifact.entities.User;

public interface CommentService {
    Comment createOrUpdateComment(
            String content,
            Long parentId,
            Long dishId,
            Long shopId,
            User user,
            Long commentId);

    Comment getComment(Long commentId);

    Set<Comment> getChildren(Long commentId);
}
