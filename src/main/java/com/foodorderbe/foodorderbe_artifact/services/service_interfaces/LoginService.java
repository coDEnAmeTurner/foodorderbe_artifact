package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import com.foodorderbe.foodorderbe_artifact.responses.LoginResp;

public interface LoginService {
    LoginResp authenticateByUserNamePassword(String username, String password);
}
