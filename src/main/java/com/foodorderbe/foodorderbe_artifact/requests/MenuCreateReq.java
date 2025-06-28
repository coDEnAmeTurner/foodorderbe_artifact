package com.foodorderbe.foodorderbe_artifact.requests;

import java.util.List;

public class MenuCreateReq {
    private String name;
    private Long shopId;
    private List<DishMenuCreateReq> dishs;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public List<DishMenuCreateReq> getDishs() {
        return dishs;
    }
    public void setDishs(List<DishMenuCreateReq> dishs) {
        this.dishs = dishs;
    }
    public MenuCreateReq() {
    }
    public MenuCreateReq(String name, Long shopId, List<DishMenuCreateReq> dishs) {
        this.name = name;
        this.shopId = shopId;
        this.dishs = dishs;
    }

    

}
