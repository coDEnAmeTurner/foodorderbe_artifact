package com.foodorderbe.foodorderbe_artifact.entities;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.foodorderbe.foodorderbe_artifact.constraints.annotations.CheckUserType;
import com.foodorderbe.foodorderbe_artifact.constraints.constraint_utils.UserTypeAuthority;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "`user`")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JsonIgnore
    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "lastLogin", nullable = true)
    private Date lastLogin;

    @Column(name = "isSuperUser", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isSuperUser;

    @Column(name = "userName", nullable = false, unique = true)
    private String userName;

    @Column(name = "firstName", nullable = false, columnDefinition = "varchar(150) default ''")
    private String firstName;

    @Column(name = "lastName", nullable = false, columnDefinition = "varchar(150) default ''")
    private String lastName;

    @Column(name = "email", nullable = true, columnDefinition = "text")
    private String email;

    @Column(name = "isStaff", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isStaff;

    @Column(name = "isActive", nullable = false, columnDefinition = "tinyint(1) default 0")
    private boolean isActive;

    @CreationTimestamp
    @Column(name = "dateJoined", nullable = false)
    private Date dateJoined;

    @Column(name = "avatar", nullable = true, columnDefinition = "text")
    private String avatar;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = true)
    private String phone;

    @CheckUserType({ UserTypeAuthority.INDIVIDUAL, UserTypeAuthority.ADMIN, UserTypeAuthority.SHOP })
    @Column(name = "type", nullable = false, columnDefinition = "varchar(10) default 'INDIVIDUAL'")
    private String type;

    @CreationTimestamp
    @Column(name = "dateCreated", nullable = false)
    private Date dateCreated;

    @UpdateTimestamp
    @Column(name = "dateModified", nullable = false)
    private Date dateModified;

    @JsonIgnore
    @Transient
    private MultipartFile file;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(() -> this.getType().toUpperCase());
    }

    @Override
    public String getUsername() {
        return userName;
    }

}
