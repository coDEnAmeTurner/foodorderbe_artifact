package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`dish`")
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Shop shop;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false, columnDefinition = "float default 0")
    private float price;

    @Column(name = "picture",nullable = false, columnDefinition = "text")
    private String picture;

    @Column(name = "available",nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean available;

    @Column(name = "daySession",nullable = true, columnDefinition = "varchar(10) default ''")
    private String daySession;

     @Column(name = "description",nullable = false, columnDefinition = "text")
    private String description;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    @JsonIgnore
    @OneToMany(mappedBy = "dish")
    private Set<Comment> comments;

    public long getId() {
        return id;
    }

   public Shop getShop() {
       return shop;
   }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getPicture() {
        return picture;
    }

    public boolean isAvailable() {
        return available;
    }

    public String getDaySession() {
        return daySession;
    }

    public String getDescription() {
        return description;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setId(long id) {
        this.id = id;
    }

   public void setShop(Shop shop) {
       this.shop = shop;
   }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public void setDaySession(String daySession) {
        this.daySession = daySession;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public Dish() {
    }

    public Dish(long id, 
   Shop shop,
    String name, float price, String picture, boolean available, String daySession,
            String description, Date dateCreated, Date dateModified) {
        this.id = id;
       this.shop = shop;
        this.name = name;
        this.price = price;
        this.picture = picture;
        this.available = available;
        this.daySession = daySession;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
}
