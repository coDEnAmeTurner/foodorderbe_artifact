package com.foodorderbe.foodorderbe_artifact.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ItemOrderCreateOrUpdateReq {
    @NotNull
    @Min(1)
    private Long itemId = 0L;
    @NotNull
    @Min(1)
    private int count = 0;
    @NotNull
    private String note = "";

    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }
    public Long getItemId() {
        return itemId;
    }
    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    public ItemOrderCreateOrUpdateReq() {
    }
    public ItemOrderCreateOrUpdateReq(Long itemId, int count, String note) {
        this.itemId = itemId;
        this.count = count;
        this.note = note;
    }
    
    
}
