package com.emami.bibliotheque.model;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Book {
    @GeneratedValue
    @Id
    private int id;
    @Column(unique = true)
    private int isbn;
    private String title;
    private String author;
    private Date created_at;

    public Book() {
    }

    public Book(int isbn, String title, String author, Date created_at) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
