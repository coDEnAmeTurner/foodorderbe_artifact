package com.foodorderbe.foodorderbe_artifact.requests;

public class DishUpdateReq {
    private String description;
    private String daySession;
    private boolean isAvailable;
    private float price;
    private String name;


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
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
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

    public DishUpdateReq() {
    }

    public DishUpdateReq(String description, String daySession, boolean isAvailable, float price,
            String name) {
        this.description = description;
        this.daySession = daySession;
        this.isAvailable = isAvailable;
        this.price = price;
        this.name = name;
    }

}
