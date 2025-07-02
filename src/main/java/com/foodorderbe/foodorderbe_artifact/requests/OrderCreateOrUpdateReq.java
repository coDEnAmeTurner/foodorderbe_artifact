package com.foodorderbe.foodorderbe_artifact.requests;

import java.util.ArrayList;
import java.util.List;

public class OrderCreateOrUpdateReq {
    private List<ItemOrderCreateOrUpdateReq> items = new ArrayList<>();
    private String purchaseType = "";
    private String shipAddress = "";
    public List<ItemOrderCreateOrUpdateReq> getItems() {
        return items;
    }
    public void setItems(List<ItemOrderCreateOrUpdateReq> items) {
        this.items = items;
    }
    public String getPurchaseType() {
        return purchaseType;
    }
    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }
    public String getShipAddress() {
        return shipAddress;
    }
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    public OrderCreateOrUpdateReq() {
    }
    public OrderCreateOrUpdateReq(List<ItemOrderCreateOrUpdateReq> items, String purchaseType, String shipAddress) {
        this.items = items;
        this.purchaseType = purchaseType;
        this.shipAddress = shipAddress;
    }

    
    
}
