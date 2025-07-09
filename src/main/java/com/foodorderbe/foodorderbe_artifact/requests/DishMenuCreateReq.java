package com.foodorderbe.foodorderbe_artifact.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishMenuCreateReq {
    private Long dishId = 0L;
    private int count = 0;
    
    
}