package com.foodorderbe.foodorderbe_artifact.requests;

public class DishGetAllReq {
    private Long shopId;
    private String name;
    private float fromPrice;
    private float toPrice;
    private boolean available;
    private String daySession;
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public float getFromPrice() {
        return fromPrice;
    }
    public void setFromPrice(float fromPrice) {
        this.fromPrice = fromPrice;
    }
    public float getToPrice() {
        return toPrice;
    }
    public void setToPrice(float toPrice) {
        this.toPrice = toPrice;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
    public String getDaySession() {
        return daySession;
    }
    public void setDaySession(String daySession) {
        this.daySession = daySession;
    }
    public DishGetAllReq() {
    }
    public DishGetAllReq(Long shopId, String name, float fromPrice, float toPrice, boolean available,
            String daySession) {
        this.shopId = shopId;
        this.name = name;
        this.fromPrice = fromPrice;
        this.toPrice = toPrice;
        this.available = available;
        this.daySession = daySession;
    }

    
}
