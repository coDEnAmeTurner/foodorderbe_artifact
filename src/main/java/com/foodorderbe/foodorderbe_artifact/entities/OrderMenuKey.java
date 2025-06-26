package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderMenuKey implements Serializable{

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "menuId")
    private Long menuId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public OrderMenuKey() {
    }

    public OrderMenuKey(Long orderId, Long menuId) {
        this.orderId = orderId;
        this.menuId = menuId;
    }

    
}
