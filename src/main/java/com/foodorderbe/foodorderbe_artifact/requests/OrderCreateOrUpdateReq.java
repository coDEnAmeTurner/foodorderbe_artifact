package com.foodorderbe.foodorderbe_artifact.requests;

import java.util.ArrayList;
import java.util.List;

import com.foodorderbe.foodorderbe_artifact.constraints.annotations.CheckPurchaseType;
import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.PurchaseType;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@ValidatorValues
public class OrderCreateOrUpdateReq {
    private List<ItemOrderCreateOrUpdateReq> items = new ArrayList<>();
    @NotNull
    @CheckPurchaseType({PurchaseType.MOMO, PurchaseType.CASH, PurchaseType.VNPAY})
    private String purchaseType = "";
    @NotNull
    @Size(min = 10, max = 200)
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
