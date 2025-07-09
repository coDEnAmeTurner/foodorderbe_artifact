package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
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

    @UpdateTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;


}
