package com.foodorderbe.foodorderbe_artifact.services.service_implements;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodorderbe.foodorderbe_artifact.entities.Menu;
import com.foodorderbe.foodorderbe_artifact.entities.MenuDish;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.DishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.MenuDishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.MenuRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.ShopRepository;
import com.foodorderbe.foodorderbe_artifact.requests.DishMenuCreateReq;
import com.foodorderbe.foodorderbe_artifact.services.service_interfaces.MenuService;
import com.foodorderbe.foodorderbe_artifact.specifications.MenuSpecs;

public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private MenuDishRepository menuDishRepository;
    @Autowired
    private DishRepository dishRepository;

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
    public Menu createOrUpdateMenu(Long menuId, String name, Long shopId, List<DishMenuCreateReq> dishs) {
        Menu m;
        if (menuId == 0)
            m  = new Menu();
        else 
            m = menuRepository.findById(menuId).get();
        m.setName(name);
        m.setShop(shopRepository.findById(shopId).get());
        menuRepository.save(m);

        if (menuId != 0)
            // menuDishRepository.
        dishs.forEach(obj->{
            MenuDish menuDish = new MenuDish();
            menuDish.setCount(obj.getCount());
            menuDish.setMenu(m);
            menuDish.setDish(dishRepository.findById(shopId).get());
            menuDishRepository.save(menuDish);
        });
        return m;
    }

    @Override
    public Menu getMenu(Long menuId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMenu'");
    }
    
}
