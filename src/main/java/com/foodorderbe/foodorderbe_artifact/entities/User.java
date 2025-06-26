package com.foodorderbe.foodorderbe_artifact.entities;

import java.io.Serializable;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "`user`")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name = "lastLogin", nullable = true)
    private Date lastLogin;

    @Column(name = "isSuperUser",nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isSuperUser;

    @Column(name = "userName",nullable = false, unique = true)
    private boolean userName;
    
    @Column(name = "firstName",nullable = false, columnDefinition = "varchar(150) default ''")
    private String firstName;

    @Column(name = "lastName",nullable = false, columnDefinition = "varchar(150) default ''")
    private String lastName;

    @Column(name = "email",nullable = true, columnDefinition = "text")
    private String email;

    @Column(name = "isStaff",nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isStaff;

    @Column(name = "isActive",nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "dateJoined", nullable = false)
    private Date dateJoined;

    @Column(name = "avatar",nullable = true, columnDefinition = "text")
    private String avatar;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "phone",nullable = true)
    private String phone;

    @Column(name = "type",nullable = false, columnDefinition = "varchar(10) default 'INDIVIDUAL'")
    private String type;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @CreationTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    public User() {
    }

    public User(Long id, String password, Date lastLogin, boolean isSuperUser, boolean userName, String firstName,
            String lastName, String email, boolean isStaff, boolean isActive, Date dateJoined, String avatar,
            String name, String phone, String type, Date dateCreated, Date dateModified) {
        this.id = id;
        this.password = password;
        this.lastLogin = lastLogin;
        this.isSuperUser = isSuperUser;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.isStaff = isStaff;
        this.isActive = isActive;
        this.dateJoined = dateJoined;
        this.avatar = avatar;
        this.name = name;
        this.phone = phone;
        this.type = type;
        this.dateCreated = dateCreated;
        this.dateModified = dateModified;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public boolean isSuperUser() {
        return isSuperUser;
    }

    public void setSuperUser(boolean isSuperUser) {
        this.isSuperUser = isSuperUser;
    }

    public boolean isUserName() {
        return userName;
    }

    public void setUserName(boolean userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isStaff() {
        return isStaff;
    }

    public void setStaff(boolean isStaff) {
        this.isStaff = isStaff;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
}
