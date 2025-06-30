package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class MenuDishKey implements Serializable {
    @Column(name = "menuId")
    public Long menuId;

    @Column(name = "dishId")
    public Long dishId;

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public MenuDishKey() {
    }

    public MenuDishKey(Long menuId, Long dishId) {
        this.menuId = menuId;
        this.dishId = dishId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((menuId == null) ? 0 : menuId.hashCode());
        result = prime * result + ((dishId == null) ? 0 : dishId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
            
        MenuDishKey other = (MenuDishKey) obj;
        if (menuId == null) {
            if (other.menuId != null)
                return false;
        } else if (!menuId.equals(other.menuId))
            return false;
        if (dishId == null) {
            if (other.dishId != null)
                return false;
        } else if (!dishId.equals(other.dishId))
            return false;
        return true;
    }

    
}