package com.emami.bibliotheque.service;

import com.emami.bibliotheque.entity.Book;

import java.util.Set;

public interface BookInventoryService {
    Book addBook(Book book);

    Book findBookById(Long id);

    Set<Book> findBooksByAuthor(String author);

    Set<Book> findBookByTitle(String title);

    Book updateBook(Book book);

    public Long deleteBookById(Long id);

}
