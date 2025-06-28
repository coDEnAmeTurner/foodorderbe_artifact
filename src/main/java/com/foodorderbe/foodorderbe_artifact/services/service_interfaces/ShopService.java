package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import com.foodorderbe.foodorderbe_artifact.entities.Shop;
import com.foodorderbe.foodorderbe_artifact.responses.ShopResp;

public interface ShopService {
    ShopResp verifyShop(Long shopId);
    ShopResp getShop(Long shopId);
    
}
