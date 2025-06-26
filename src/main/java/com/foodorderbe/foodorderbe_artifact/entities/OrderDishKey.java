package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderDishKey implements Serializable {
    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "dishId")
    private Long dishId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public OrderDishKey() {
    }

    public OrderDishKey(Long orderId, Long dishId) {
        this.orderId = orderId;
        this.dishId = dishId;
    }

    
}
