package com.jotadev.socialmediamongo.dto;

import com.jotadev.socialmediamongo.domain.User;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    // attributes
    private String id;
    private String name;
    private String email;

    // constructor
    public UserDTO(){
    }

    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }

    // getters and setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
