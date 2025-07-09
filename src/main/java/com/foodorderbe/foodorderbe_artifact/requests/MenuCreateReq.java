package com.foodorderbe.foodorderbe_artifact.requests;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MenuCreateReq {
    private String name = "";
    private Long shopId = 0L;
    private List<DishMenuCreateReq> dishs;
    

}
