package com.foodorderbe.foodorderbe_artifact.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateReq {
    private String password;

    private String email;

    private String lastName;

    private String firstName;

    private String userName;

    private String type;

    private String phone;

    private String name;

    
}
