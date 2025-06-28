package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.UserRepository;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.UserService;

@Service("userDetailsService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Cloudinary cloudinary;
    @Autowired
    private PasswordEncoder encoder;

    @Override
    public User createUser(String password, String email, String lastName, String firstName, String userName,
            String type, String phone, String name,
            MultipartFile file) {
        User u = new User();
        //set up spring security for password encoder
        u.setPassword(encoder.encode(password));
        u.setEmail(email);
        u.setLastName(lastName);
        u.setFirstName(firstName);
        u.setUserName(userName);
        u.setType(type);
        u.setPhone(phone);
        u.setName(name);
        
        if (!file.isEmpty()){
            try {
                Map res = this.cloudinary.uploader().upload(file.getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                u.setAvatar(res.get("secure_url").toString());
            } catch (IOException ex) {
                Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        userRepository.save(u);

        return u;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUserName(username);
        if (u == null) {
            throw new UsernameNotFoundException("Invalid username!");
        }
        //come back later for spring security
        return null;
    }
}
