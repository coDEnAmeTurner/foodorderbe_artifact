package com.foodorderbe.foodorderbe_artifact.repositories.repository_implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.foodorderbe.foodorderbe_artifact.entities.MenuDish;
import com.foodorderbe.foodorderbe_artifact.entities.MenuDishKey;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.CustomMenuDishRepository;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.MenuRepository;

import jakarta.transaction.Transactional;

@Repository
public class MenuDishRepositoryImpl implements CustomMenuDishRepository{

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Autowired
    MenuRepository menuRepository;

    @Override
    @Transactional
    public void customDeleteAllByMenuId(Long menuId) {
        var session = sessionFactory.getObject().getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var delete = builder.createCriteriaDelete(MenuDish.class);
        var root = delete.from(MenuDish.class);

        delete.where(builder.equal(root.get("menu").get("id"), menuId));

        session.createQuery(delete).executeUpdate();
    }
    
}
