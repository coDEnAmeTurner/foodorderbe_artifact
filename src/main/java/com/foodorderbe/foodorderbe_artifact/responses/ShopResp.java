package com.foodorderbe.foodorderbe_artifact.responses;

import java.io.Serializable;

import com.foodorderbe.foodorderbe_artifact.entities.Shop;
import com.foodorderbe.foodorderbe_artifact.entities.User;

public class ShopResp implements Serializable {
    private Shop shop;
    private User user;
    public Shop getShop() {
        return shop;
    }
    public void setShop(Shop shop) {
        this.shop = shop;
    }
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public ShopResp() {
    }
    public ShopResp(Shop shop, User user) {
        this.shop = shop;
        this.user = user;
    }

    
}

