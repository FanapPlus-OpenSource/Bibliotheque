package com.emami.bibliotheque.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class User extends BaseEntity {
    private String name;
    private String email;
    @Column(name = "created_at")
    private Date createdAt = Date.from(Instant.now());

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserBook> userBooks = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<UserBook> getUserBooks() {
        return userBooks;
    }

    public void setUserBooks(Set<UserBook> userBooks) {
        this.userBooks = userBooks;
        userBooks.forEach(it -> it.setUser(this));
    }

    public void addUserBook(UserBook userBook) {
        getUserBooks().add(userBook);
        userBook.setUser(this);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
