package com.emami.bibliotheque.service;

import com.emami.bibliotheque.api.v1.model.BookDTO;

import java.util.List;
public interface BookInventoryService {
    BookDTO addBook(BookDTO book);

    BookDTO findBookById(Long id);

    List<BookDTO> findBooksByAuthor(String author);

    List<BookDTO> findBookByTitle(String title);

    BookDTO updateBook(BookDTO book);

    Long deleteBookById(Long id);

}
