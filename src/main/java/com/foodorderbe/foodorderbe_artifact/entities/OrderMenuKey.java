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
public class OrderMenuKey implements Serializable{

    @Column(name = "orderId")
    private Long orderId;

    @Column(name = "menuId")
    private Long menuId;

    

    
}
