package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class MenuDishKey implements Serializable {
    @Column(name = "menuId")
    private Long menuId;

    @Column(name = "dishId")
    private Long dishId;

    
}