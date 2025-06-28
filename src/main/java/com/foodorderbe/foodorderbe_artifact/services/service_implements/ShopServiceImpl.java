package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodorderbe.foodorderbe_artifact.entities.Shop;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.ShopRepository;
import com.foodorderbe.foodorderbe_artifact.responses.ShopResp;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.ShopService;

@Service
public class ShopServiceImpl implements ShopService {
    @Autowired
    ShopRepository shopRepository;

    @Override
    public ShopResp verifyShop(Long shopId) {
        var opShop = shopRepository.findById(shopId);
        if (!opShop.isPresent()) {
            return null;
        }

        var shop = opShop.get() ;
        shop.setValid(true);
        shopRepository.save(shop);

        var shopUser = shop.getUser();
        var resp = new ShopResp(shop,shopUser);

        return resp;
    }

    @Override
    public ShopResp getShop(Long shopId) {
        var shop = shopRepository.findById(shopId)  ;
        if (!shop.isPresent())
            return null;

        var user = shop.get().getUser();
        var resp = new ShopResp(shop.get(),user);

        return resp;
    }
    
}
