package com.foodorderbe.foodorderbe_artifact.repositories.repository_implements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import com.foodorderbe.foodorderbe_artifact.entities.MenuDish;
import com.foodorderbe.foodorderbe_artifact.repositories.repository_interfaces.CustomMenuDishRepository;

import jakarta.transaction.Transactional;

@Repository
public class CustomMenuDishRepositoryImpl implements CustomMenuDishRepository{

    @Autowired
    LocalSessionFactoryBean sessionFactory;

    @Override
    public void deleteAllByMenu(Long menuId) {
        var session = sessionFactory.getObject().getCurrentSession();
        var builder = session.getCriteriaBuilder();
        var query = builder.createCriteriaDelete(MenuDish.class);
        var root = query.from(MenuDish.class);
        query.where(builder.equal(root.get("menu").get("id"), menuId));

        var transaction = session.beginTransaction();
        session.createQuery(query).executeUpdate();
        transaction.commit();
    }
    
}
