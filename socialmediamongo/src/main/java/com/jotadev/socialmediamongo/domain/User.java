package com.jotadev.socialmediamongo.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Document(collection = "user")       // indica pro mongoDb que esta classe é uma coleção lá no banco de dados
public class User implements Serializable {

    private static final long serialVersionUUID = 1L;

    // attributes
    @Id
    private String id;
    private String name;
    private String email;

    // lazy = true, garante com que os posts relacionados a este user não venha automaticamente quando recuperar
    // os dados deste usuário, só serão carregados os posts quando explicitamente forem solicitados

    @DBRef(lazy = true)  // indica que o atributo é uma referência a outra coleção do mongoDB
    private List<Post> posts = new ArrayList<>();

    // constructors
    public User(){
    }

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public List<Post> getPosts(){
        return this.posts;
    }

    // hashCode and equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
