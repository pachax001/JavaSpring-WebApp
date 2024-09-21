package com.rumal001.webapp.Models;


import com.rumal001.webapp.Enums.Role;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass
public abstract class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String password;
    private Role role;
    private String profileURL;
    private Boolean deleted = false;
    private LocalDateTime createdTimeStamp = LocalDateTime.now();

    public User (){

    }
    //Viewer Registration
    public User(String firstName, String lastName, String email, String mobile, String password, String profileURL, LocalDateTime createdTimeStamp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.profileURL = profileURL;
        this.createdTimeStamp = createdTimeStamp;
    }
    // Moderator Registration
    public User(String firstName, String lastName, String email, String mobile, String password, String profileURL) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.profileURL = profileURL;
    }

    //getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProfileurl() {
        return profileURL;
    }

    public void setProfileurl(String profileURL) {
        this.profileURL = profileURL;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public LocalDateTime getCreatedTimeStamp() {
        return createdTimeStamp;
    }

    public void setCreatedTimeStamp(LocalDateTime createdTimeStamp) {
        this.createdTimeStamp = createdTimeStamp;
    }

    public boolean isDeleted() {
        return deleted;
    }
}
