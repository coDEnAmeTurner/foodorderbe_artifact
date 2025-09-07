package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.api.exceptions.NotFound;
import com.foodorderbe.foodorderbe_artifact.entities.User;

public interface UserService extends UserDetailsService {
        User createUser(
                        String password,
                        String email,
                        String lastName,
                        String firstName,
                        String userName,
                        String type,
                        String phone,
                        String name,
                        MultipartFile file);

        User updateUser(
                        Long id,
                        String password,
                        String email,
                        String lastName,
                        String firstName,
                        String userName,
                        String type,
                        String phone,
                        String name,
                        MultipartFile file) throws NotFound;

        User updatePass(
                        Long id,
                        String password) throws NotFound;

        User getUser(Long userId);
}
