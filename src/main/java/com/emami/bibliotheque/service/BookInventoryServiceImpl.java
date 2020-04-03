package com.emami.bibliotheque.service;

import com.emami.bibliotheque.api.v1.mapper.BookMapper;
import com.emami.bibliotheque.api.v1.model.BookDTO;
import com.emami.bibliotheque.entity.Book;
import com.emami.bibliotheque.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//TODO Write tests
@Service
public class BookInventoryServiceImpl implements BookInventoryService {

    private BookRepository bookRepository;
    private BookMapper bookMapper;

    public BookInventoryServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookDTO addBook(BookDTO book) {

        return bookMapper.bookToBookDTO(bookRepository.save(bookMapper.bookDtoToBook(book)));
    }

    @Override
    public BookDTO findBookById(Long id) {
        return bookMapper.bookToBookDTO(bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book doesn't exist")));
    }

    @Override
    public BookDTO updateBook(BookDTO book) {
        Optional<Book> bookInDb = bookRepository.findById(book.getId());
        return bookMapper.bookToBookDTO(bookRepository.save(bookInDb.orElseThrow(() -> new RuntimeException("Book id is not correct"))));
    }

    @Override
    public Long deleteBookById(Long id) {
        bookRepository.deleteById(id);
        return id;
    }

    @Override
    public List<BookDTO> findBooksByAuthor(String author) {
        return bookRepository.findBooksByAuthor(author).orElseGet(ArrayList::new)
                .stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookDTO> findBookByTitle(String title) {
        return bookRepository.findBooksByTitleLike(title).orElseGet(ArrayList::new).stream()
                .map(bookMapper::bookToBookDTO)
                .collect(Collectors.toList());
    }
}
