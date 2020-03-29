package com.emami.bibliotheque.service;

import com.emami.bibliotheque.entity.Book;
import com.emami.bibliotheque.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookInventoryServiceImpl implements BookInventoryService {

    private BookRepository bookRepository;

    public BookInventoryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        Optional<Book> optionalBook = Optional.of(book);
        if (optionalBook.isPresent()) {
            return bookRepository.save(book);
        } else {
            throw new RuntimeException("Book can not be null!");
        }
    }

    @Override
    public Book findBookById(Long id) {
        return null;
    }

    @Override
    public Book updateBook(Book book) {
        return null;
    }

    @Override
    public Long deleteBook(Book book) {
        return null;
    }
}
