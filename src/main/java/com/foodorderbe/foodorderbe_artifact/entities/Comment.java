package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "`comment`")
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to User
    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    // Foreign key to Shop (referencing Shop.userId)
    @ManyToOne
    @JoinColumn(name = "shopId", nullable = true)
    private Shop shop;

    // Foreign key to Dish
    @ManyToOne
    @JoinColumn(name = "dishId", nullable = true)
    private Dish dish;

    // Self-referencing comment (parent)
    @ManyToOne
    @JoinColumn(name = "parentId", nullable = true)
    private Comment parent;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public Comment getParent() {
        return parent;
    }

    public void setParent(Comment parent) {
        this.parent = parent;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    public Comment() {
    }

    public Comment(Long id, User user, Shop shop, Dish dish, Comment parent, String content, Date dateCreated,
            Date dateModified) {
        this.id = id;
        this.user = user;
        this.shop = shop;
        this.dish = dish;
        this.parent = parent;
        this.content = content;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
}
