package com.emami.bibliotheque.service;

import com.emami.bibliotheque.api.v1.mapper.BookMapper;
import com.emami.bibliotheque.api.v1.model.BookDTO;
import com.emami.bibliotheque.repositories.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertThrows;

class BookInventoryServiceImplTest {

    @Mock
    BookRepository bookRepository;
    BookMapper bookMapper = BookMapper.INSTANCE;
    BookInventoryService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bookService = new BookInventoryServiceImpl(bookRepository);
    }

    @Test
    void should_throw_exception_with_wrong_book_id_to_find() {
        Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(null);
        assertThrows(RuntimeException.class, () -> bookService.findBookById(123L));
    }

    @Test
    void should_throw_exception_with_wrong_book_id_to_update() {
        Mockito.when(bookRepository.findById(Mockito.anyLong())).thenReturn(null);
        assertThrows(RuntimeException.class, () -> bookService.updateBook(new BookDTO(null, "hello", "hello", 123123123123L, null)));
    }
}