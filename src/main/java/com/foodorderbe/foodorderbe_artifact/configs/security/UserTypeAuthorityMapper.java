package com.foodorderbe.foodorderbe_artifact.configs.security;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;

import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.UserTypeAuthority;

public class UserTypeAuthorityMapper implements GrantedAuthoritiesMapper {

    // Constants for group defined in LDAP
    private final String ROLE_ADMIN = "ADMIN";
    private final String ROLE_INDIVIDUAL = "USER";
    private final String ROLE_SHOP = "SHOP";

    public UserTypeAuthorityMapper() {
    }

    @Override
    public Collection<? extends GrantedAuthority> mapAuthorities(final Collection<? extends GrantedAuthority> authorities) {

        Set<UserTypeAuthority> roles = EnumSet.noneOf(UserTypeAuthority.class);

        for (GrantedAuthority authority : authorities) {

            System.out.println("GrantedAuthority : " + authority.getAuthority());

            if (ROLE_ADMIN.equals(authority.getAuthority())) {
                roles.add(UserTypeAuthority.ADMIN);
            }

            if (ROLE_INDIVIDUAL.equals(authority.getAuthority())) {
                roles.add(UserTypeAuthority.INDIVIDUAL);
            }

            if (ROLE_SHOP.equals(authority.getAuthority())) {
                roles.add(UserTypeAuthority.SHOP);
            }
        }

        return roles;
    }

}
