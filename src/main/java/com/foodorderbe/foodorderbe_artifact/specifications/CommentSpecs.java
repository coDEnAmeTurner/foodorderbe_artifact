package com.foodorderbe.foodorderbe_artifact.specifications;

import org.springframework.data.jpa.domain.Specification;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;

public class CommentSpecs {
    public static Specification<Comment> isOfDish(Long dishId) {
        return (root,query,builder)->{
            return builder.equal(root.get("dish").get("id"), dishId);
        };
    }
}
