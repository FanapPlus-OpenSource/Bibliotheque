package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.entity.Book;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    void should_successfully_add_book() {
        Book book = new Book("Hessam", "Hessam", 123123123123L);
        Book addedBook = bookRepository.save(book);
        assertEquals(book.getIsbn(), addedBook.getIsbn());
    }

    @Test
    void should_throw_exception_with_invalid_isbn_range() {
        Long isbn = 1233123L;
        assertThrows(ConstraintViolationException.class, () -> {
            bookRepository.save(new Book("test", "test", isbn));
        });
    }

    @Test
    void should_throw_exception_with_invalid_isbn_range2() {
        Long isbn = 1233123456456456546L;
        assertThrows(ConstraintViolationException.class, () -> {
            bookRepository.save(new Book("test", "test", isbn));
        });
    }

    @Test
    void should_throw_with_title_length_smaller_than_two() {
        assertThrows(ConstraintViolationException.class, () -> {
            bookRepository.save(new Book("t", "test", 123123123222L));
        });
    }

    @Test
    void should_successfully_find_book_by_title() {
        bookRepository.save(new Book("Les miserables", "Victor Hugo", 45323412131L));

        Optional<Book> bookByTitle = bookRepository.findBookByTitle("Les miserables");

        assertNotNull(bookByTitle.get());
        assertEquals(bookByTitle.get().getTitle(), "Les miserables");
    }

    @Test
    void should_successfully_find_books_by_author() {
        String author = "Victor Hugo";
        bookRepository.save(new Book("Les miserables", author, 45323412131L));
        bookRepository.save(new Book("Les armas", author, 45323442131L));
        bookRepository.save(new Book("Les ismaeil", author, 45323442131L));

        Optional<List<Book>> bookByTitle = bookRepository.findBooksByAuthor(author);

        assertNotNull(bookByTitle.get());
        assertEquals(bookByTitle.get().size(), 3);
        assertEquals(bookByTitle.get().get(0).getAuthor(), author);
    }

    @Test
    void should_successfully_update_book() {
        Book book = new Book("Hello", "Author", 342342342341L);
        Book savedBook = bookRepository.save(book);
        Long savedBookId = savedBook.getId();

        assertEquals(savedBook.getTitle(), "Hello");
        savedBook.setTitle("Bye");
        bookRepository.save(savedBook);

        Optional<Book> bookById = bookRepository.findById(savedBookId);
        assertNotNull(bookById.get());
        assertNotEquals(bookById.get().getTitle(), "Hello");
        assertEquals(bookById.get().getTitle(), "Bye");
    }
}