package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MenuDishKey implements Serializable {
    @Column(name = "menuId")
    public Long menuId;

    @Column(name = "dishId")
    public Long dishId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public MenuDishKey() {
    }

    public MenuDishKey(Long menuId, Long dishId) {
        this.menuId = menuId;
        this.dishId = dishId;
    }

    
}