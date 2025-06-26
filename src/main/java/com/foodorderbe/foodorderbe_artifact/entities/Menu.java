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
@Table(name = "`menu`")
public class Menu implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 350, nullable = false)
    private String name = "Thực Đơn";

    @ManyToOne
    @JoinColumn(name = "shopId", nullable = true)
    private Shop shop;

    @Column(nullable = false)
    @CreationTimestamp
    private Date dateCreated;

    @Column(nullable = false)
    @CreationTimestamp
    private Date dateModified;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
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

    public Menu() {
    }

    public Menu(Long id, String name, Shop shop, Date dateCreated, Date dateModified) {
        this.id = id;
        this.name = name;
        this.shop = shop;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
}
