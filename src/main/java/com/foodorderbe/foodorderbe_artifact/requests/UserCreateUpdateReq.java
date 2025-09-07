package com.foodorderbe.foodorderbe_artifact.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserCreateUpdateReq {
    private String password = null;

    private String email = null;

    private String lastName = null;

    private String firstName = null;

    private String userName = null;

    private String type = null;

    private String phone = null;

    private String name = null;

}
