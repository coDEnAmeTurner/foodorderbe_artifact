package com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces;

import org.springframework.data.repository.CrudRepository;

import com.foodorderbe.foodorderbe_artifact.entities.User;

public interface UserRepository extends CrudRepository<User,Long> {
    User findByUserName(String userName);
}
