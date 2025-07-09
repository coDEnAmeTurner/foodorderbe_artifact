package com.foodorderbe.foodorderbe_artifact.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DishCreateUpdateReq {
    private String description;
    private String daySession;
    private boolean available;
    private float price;
    private String name;
    private long shopId;

    

}
