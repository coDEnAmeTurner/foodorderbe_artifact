package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name="`shop`")
public class Shop implements Serializable {
    @Id
    @Column(name = "userId")    
    private Long userId;

    @MapsId
    @OneToOne
    private User user;  

    @Column(name = "location",nullable = false, columnDefinition = "text")
    private String location;

    @Column(name = "isValid",nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isValid;

    @Column(name = "shipPayment",nullable = false, columnDefinition = "float default 0")
    private float shipPayment;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public float getShipPayment() {
        return shipPayment;
    }

    public void setShipPayment(float shipPayment) {
        this.shipPayment = shipPayment;
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

    public Shop() {
    }

    public Shop(Long userId, User user, String location, boolean isValid, float shipPayment, Date dateCreated,
            Date dateModified) {
        this.userId = userId;
        this.user = user;
        this.location = location;
        this.isValid = isValid;
        this.shipPayment = shipPayment;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
    
}