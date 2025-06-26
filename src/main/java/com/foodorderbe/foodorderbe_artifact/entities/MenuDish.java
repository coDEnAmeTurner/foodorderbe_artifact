package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "`menuDish`")
public class MenuDish implements Serializable {
    @EmbeddedId
    private MenuDishKey id;

    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name = "menuId")
    private Menu menu;

    @ManyToOne
    @MapsId("dishId")
    @JoinColumn(name = "dishId")
    private Dish dish;

    @Column(name = "count", nullable = false, columnDefinition = "int default 0")
    private int count;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    public MenuDishKey getId() {
        return id;
    }

    public void setId(MenuDishKey id) {
        this.id = id;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public MenuDish() {
    }

    public MenuDish(MenuDishKey id, Menu menu, Dish dish, int count, Date dateCreated, Date dateModified) {
        this.id = id;
        this.menu = menu;
        this.dish = dish;
        this.count = count;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
}
