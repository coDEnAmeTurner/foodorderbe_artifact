package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foodorderbe.foodorderbe_artifact.constraints.annotations.CheckPurchaseType;
import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.PurchaseType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "`order`")
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name="userId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private User user;

    @Column(name = "isValid",nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isValid;

    @Column(name = "paymentType",nullable = false, columnDefinition = "varchar(10) default 'CASH'")
    private String paymentType;

    @Column(name = "totalPrice",nullable = false, columnDefinition = "float default 0")
    private float totalPrice;

    @Column(name = "shipAddress",nullable = false, columnDefinition = "text")
    private String shipAddress;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    private Set<OrderDish> orderDishs;

    @Column(name = "shipPayment", nullable = true)
    private float shipPayment;

    public float getShipPayment() {
        return shipPayment;
    }

    public void setShipPayment(float shipPayment) {
        this.shipPayment = shipPayment;
    }

    public Set<OrderDish> getOrderDishs() {
        return orderDishs;
    }

    public void setOrderDishs(Set<OrderDish> orderDishs) {
        this.orderDishs = orderDishs;
    }

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

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean isValid) {
        this.isValid = isValid;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
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

    public Order(Long id, User user, boolean isValid, String paymentType, float totalPrice, String shipAddress,
            Date dateCreated, Date dateModified, float shipPayment) {
        this.id = id;
        this.user = user;
        this.isValid = isValid;
        this.paymentType = paymentType;
        this.totalPrice = totalPrice;
        this.shipAddress = shipAddress;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
        this.shipPayment = shipPayment;
    }

    public Order() {
    }

    
}
