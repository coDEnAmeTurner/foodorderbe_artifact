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
@Table(name = "`orderMenu`")
public class OrderMenu implements Serializable {

    @EmbeddedId
    private OrderMenuKey id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name =  "orderId")
    private Order order;

    @ManyToOne
    @MapsId("menuId")
    @JoinColumn(name =  "menuId")
    private Menu menu;

    @Column(name = "count", nullable = false, columnDefinition = "int default 0")
    private int count;

    @Column(name = "sideNote", columnDefinition = "TEXT")
    private String sideNote;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    public OrderMenuKey getId() {
        return id;
    }

    public void setId(OrderMenuKey id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getSideNote() {
        return sideNote;
    }

    public void setSideNote(String sideNote) {
        this.sideNote = sideNote;
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

    public OrderMenu() {
    }

    public OrderMenu(OrderMenuKey id, Order order, Menu menu, int count, String sideNote, Date dateCreated,
            Date dateModified) {
        this.id = id;
        this.order = order;
        this.menu = menu;
        this.count = count;
        this.sideNote = sideNote;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    
}
