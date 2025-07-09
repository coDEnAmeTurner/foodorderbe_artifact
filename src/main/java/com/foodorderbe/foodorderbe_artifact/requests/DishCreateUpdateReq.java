package com.foodorderbe.foodorderbe_artifact.requests;

public class DishCreateUpdateReq {
    private String description;
    private String daySession;
    private boolean available;
    private float price;
    private String name;
    private long shopId;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDaySession() {
        return daySession;
    }

    public void setDaySession(String daySession) {
        this.daySession = daySession;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean isAvailable) {
        this.available = isAvailable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DishCreateUpdateReq() {
    }

    public DishCreateUpdateReq(String description, String daySession, boolean isAvailable, float price,
            String name, int shopId) {
        this.description = description;
        this.daySession = daySession;
        this.available = isAvailable;
        this.price = price;
        this.name = name;
        this.shopId = shopId;
    }

}
