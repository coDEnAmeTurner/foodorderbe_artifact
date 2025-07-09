package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
@Table(name = "`dish`")
public class Dish implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopId")
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Shop shop;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "price",nullable = false, columnDefinition = "float default 0")
    private float price;

    @Column(name = "picture",nullable = false, columnDefinition = "text")
    private String picture;

    @Column(name = "available",nullable = false, columnDefinition = "tinyint(1) default 1")
    private boolean available;

    @Column(name = "daySession",nullable = true, columnDefinition = "varchar(10) default ''")
    private String daySession;

     @Column(name = "description",nullable = false, columnDefinition = "text")
    private String description;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    @JsonIgnore
    @OneToMany(mappedBy = "dish")
    private Set<Comment> comments;

    

    
}
