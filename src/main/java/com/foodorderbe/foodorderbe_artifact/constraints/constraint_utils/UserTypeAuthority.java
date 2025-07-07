package com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils;

import org.springframework.security.core.GrantedAuthority;

public enum UserTypeAuthority implements GrantedAuthority {
    INDIVIDUAL,
    ADMIN,
    SHOP;

    @Override
    public String getAuthority() {
        return name();
    }
}
