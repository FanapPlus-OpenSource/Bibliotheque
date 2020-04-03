package com.emami.bibliotheque.api.v1.mapper;

import com.emami.bibliotheque.api.v1.model.BookDTO;
import com.emami.bibliotheque.entity.Book;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BookMapperTest {
    BookMapper bookMapper = BookMapper.INSTANCE;

    @Test
    void should_successfully_convert_toDTO() {
        Book book = new Book("Hello", "Author", 123123123123L);
        BookDTO bookDTO = bookMapper.bookToBookDTO(book);

        assertEquals(book.getIsbn(), bookDTO.getIsbn());
    }

}