package com.emami.bibliotheque.service;

import com.emami.bibliotheque.entity.Book;
import com.emami.bibliotheque.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//TODO Write tests
@Service
public class BookInventoryServiceImpl implements BookInventoryService {

    private BookRepository bookRepository;

    public BookInventoryServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book doesn't exist"));
    }

    @Override
    public Book updateBook(Book book) {
        Optional<Book> bookInDb = bookRepository.findById(book.getId());
        return bookRepository.save(bookInDb.orElseThrow(() -> new RuntimeException("Book id is not correct")));
    }

    @Override
    public Long deleteBookById(Long id) {
        bookRepository.deleteById(id);
        return id;
    }

    @Override
    public List<Book> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author).orElseGet(ArrayList::new);
    }

    @Override
    public List<Book> findBookByTitle(String title) {
        return bookRepository.findBooksByTitleLike(title).orElseGet(ArrayList::new);
    }
}
