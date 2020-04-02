package com.emami.bibliotheque.entity;

import lombok.EqualsAndHashCode;

import javax.persistence.*;

@EqualsAndHashCode
@Entity
public class UserBook {

    @EmbeddedId
    private UserBookId id;


    @MapsId("bookId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Book book;

    @MapsId("userId")
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;

    private Boolean isReturned = false;

    public UserBook(Book book, User user) {
        super();
        this.book = book;
        this.user = user;
        UserBookId userBookId = new UserBookId();
        userBookId.setBookId(book.getId());
        userBookId.setUserId(user.getId());
        this.id = userBookId;
    }

    public UserBook() {

    }

    public Boolean getReturned() {
        return isReturned;
    }

    public void setReturned(Boolean returned) {
        isReturned = returned;
    }

    public UserBookId getId() {
        return id;
    }

    public void setId(UserBookId id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "UserBook{" +
                "id=" + id +
                ", book=" + book +
                ", user=" + user +
                ", isReturned=" + isReturned +
                '}';
    }
}
