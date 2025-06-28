package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.foodorderbe.foodorderbe_artifact.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>, JpaSpecificationExecutor<Comment>{
    
}
