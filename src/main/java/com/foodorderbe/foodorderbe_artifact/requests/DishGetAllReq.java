package com.foodorderbe.foodorderbe_artifact.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishGetAllReq {
    private Long shopId;
    private String name;
    private float fromPrice;
    private float toPrice;
    private boolean available;
    private String daySession;
    
}
