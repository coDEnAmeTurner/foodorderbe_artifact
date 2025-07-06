package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.foodorderbe.foodorderbe_artifact.configs.security.JwtUtils;
import com.foodorderbe.foodorderbe_artifact.entities.User;
import com.foodorderbe.foodorderbe_artifact.responses.LoginResp;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.LoginService;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public LoginResp authenticateByUserNamePassword(String username, String password) {
        Authentication authenticationRequest =
			UsernamePasswordAuthenticationToken.unauthenticated(username, password);

        Authentication authenticationResponse =
            this.authenticationManager.authenticate(authenticationRequest);
        
        
        return new LoginResp(
            JwtUtils.generateJwtToken(authenticationResponse),
            (User)authenticationResponse.getPrincipal()
            );
    }
    
}
