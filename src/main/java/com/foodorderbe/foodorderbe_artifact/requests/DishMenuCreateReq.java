package com.foodorderbe.foodorderbe_artifact.requests;

public class DishMenuCreateReq {
    private Long dishId;
    private int count;
    public Long getDishId() {
        return dishId;
    }
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public DishMenuCreateReq() {
    }
    public DishMenuCreateReq(Long dishId, int count) {
        this.dishId = dishId;
        this.count = count;
    }
    
}