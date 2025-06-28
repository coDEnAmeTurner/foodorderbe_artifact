package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.MenuRepository;
import com.foodorderbe.foodorderbe_artifact.requests.DishMenuCreateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.MenuService;
import com.foodorderbe.foodorderbe_artifact.specifications.MenuSpecs;

public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenus(Long shopId, String name) {
        return menuRepository.findAll(MenuSpecs.containsName(name).and(MenuSpecs.isOfShop(shopId))); 
    }

    @Override
    public Menu destroyMenu(Long menuId) {
        var menu = menuRepository.findById(menuId);
        if (!menu.isPresent())
        return null;

        menuRepository.deleteById(menuId);
        return menu.get();
    }

    @Override
    public Menu createOrUpdateMenu(String name, Long shopId, List<DishMenuCreateReq> dishs) {
        Menu m = new Menu();
        m.setName(name);
        return m;
    }

    @Override
    public Menu getMenu(Long menuId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenu'");
    }
    
}
