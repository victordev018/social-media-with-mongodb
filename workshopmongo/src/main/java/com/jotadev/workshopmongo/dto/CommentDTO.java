package com.jotadev.workshopmongo.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class CommentDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    // attributes
    private String text;
    private LocalDate date;
    private AuthorDTO author;


    // constructors
    public CommentDTO(){
    }

    public CommentDTO(String text, LocalDate date, AuthorDTO author) {
        this.text = text;
        this.date = date;
        this.author = author;
    }

    // getters and setters
    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
