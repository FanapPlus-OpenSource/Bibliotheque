package com.emami.bibliotheque.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book extends BaseEntity {
    private String title;
    private String author;
    private int isbn;

    @OneToMany(mappedBy = "book")
    private Set<UserBook> userBooks = new HashSet<>();

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(Set<UserBook> userBooks) {
        this.userBooks = userBooks;
        userBooks.forEach(i -> i.setBook(this));
    }

    public void addBook(UserBook userBook) {
        getUserBooks().add(userBook);
        userBook.setBook(this);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }
}
