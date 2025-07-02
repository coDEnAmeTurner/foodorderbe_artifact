package com.foodorderbe.foodorderbe_artifact.requests;

public class CommentCreateOrUpdateReq {
    private String content = "";
    private Long parentId = 0L;
    private Long dishId = 0L;
    private Long shopId = 0L;
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Long getParentId() {
        return parentId;
    }
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    public Long getDishId() {
        return dishId;
    }
    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }
    public Long getShopId() {
        return shopId;
    }
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }
    public CommentCreateOrUpdateReq() {
    }
    public CommentCreateOrUpdateReq(String content, Long parentId, Long dishId, Long shopId) {
        this.content = content;
        this.parentId = parentId;
        this.dishId = dishId;
        this.shopId = shopId;
    }
    
    
    

}
