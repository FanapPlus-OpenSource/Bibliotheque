package com.emami.bibliotheque.service;

import com.emami.bibliotheque.entity.Book;

import java.util.List;
public interface BookInventoryService {
    Book addBook(Book book);

    Book findBookById(Long id);

    List<Book> findBooksByAuthor(String author);

    List<Book> findBookByTitle(String title);

    Book updateBook(Book book);

    public Long deleteBookById(Long id);

}
