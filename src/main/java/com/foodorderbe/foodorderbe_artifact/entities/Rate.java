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
@Table(name = "`rate`")
public class Rate implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key to User
    @ManyToOne
    @JoinColumn(name = "userId", nullable = true)
    private User user;

    // Foreign key to Dish
    @ManyToOne
    @JoinColumn(name = "dishId", nullable = true)
    private Dish dish;

    @Column(nullable = false)
    private int stars = 1;

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

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
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

    public Rate() {
    }

    public Rate(Long id, User user, Dish dish, int stars, Date dateCreated, Date dateModified) {
        this.id = id;
        this.user = user;
        this.dish = dish;
        this.stars = stars;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
}
