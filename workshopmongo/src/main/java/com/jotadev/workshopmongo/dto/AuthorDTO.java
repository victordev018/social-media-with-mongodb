package com.jotadev.workshopmongo.dto;

import com.jotadev.workshopmongo.domain.User;

import java.io.Serializable;

public class AuthorDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    // Attributes
    private String id;
    private String name;

    // constructors
    public AuthorDTO(){
    }

    public AuthorDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
    }

    // getters and setters
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
