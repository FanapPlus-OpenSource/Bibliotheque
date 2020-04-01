package com.emami.bibliotheque.entity;

import com.emami.bibliotheque.util.InvalidInputException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void should_trim_spaced_title_from_end_and_start() {
        String title = "    Angels    ";
        Book book = new Book(title, "author", 123123123123123L);
        assertNotEquals(book.getTitle(), title);
        assertEquals(book.getTitle(), "Angels");
    }

    @Test
    void should_throw_when_title_contains_invalid_chars() {
        String title = "/-:;Angels";
        assertThrows(InvalidInputException.class, () -> new Book(title, "Author", 123123213L));
    }

    @Test
    void should_not_throw_with_valid_title() {
        String title = "Angels";
        assertDoesNotThrow(() -> new Book(title, "Author", 123123213L));
    }

    @Test
    void should_throw_when_author_contains_invalid_chars() {
        String author = "/-:;Angels";
        assertThrows(InvalidInputException.class, () -> new Book("Author", author, 123123213L));
    }

    @Test
    void should_not_throw_with_valid_author() {
        String author = "Angels";
        assertDoesNotThrow(() -> new Book("Author", author, 123123213L));
    }
}