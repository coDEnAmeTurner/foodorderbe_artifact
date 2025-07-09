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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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


    
}
