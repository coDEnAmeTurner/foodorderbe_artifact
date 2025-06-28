package com.foodorderbe.foodorderbe_artifact.services.service_interfaces;

import java.util.List;

import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.requests.DishMenuCreateReq;

public interface MenuService {
    List<Menu> getAllMenus(Long shopId, String name);

    Menu destroyMenu(Long menuId);

    Menu createOrUpdateMenu(
            String name,
            Long shopId,
            List<DishMenuCreateReq> dishs);

    Menu getMenu(Long menuId);
}
