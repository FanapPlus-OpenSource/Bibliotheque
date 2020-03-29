package com.emami.bibliotheque.service;

import com.emami.bibliotheque.entity.Book;

public interface BookInventoryService {
    Book addBook(Book book);

    Book findBookById(Long id);

    Book updateBook(Book book);

    Long deleteBook(Book book);
}
