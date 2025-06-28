package com.foodorderbe.foodorderbe_artifact.requests;

public class DishMenuCreateReq {
    private Long dishId;
    private Long count;
    public Long getDishId() {
        return dishId;
    }
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
    public Long getCount() {
        return count;
    }
    public void setCount(Long count) {
        this.count = count;
    }
    public DishMenuCreateReq() {
    }
    public DishMenuCreateReq(Long dishId, Long count) {
        this.dishId = dishId;
        this.count = count;
    }
    
}