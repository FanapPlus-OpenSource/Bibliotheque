package com.emami.bibliotheque.controller.v1;

import com.emami.bibliotheque.api.v1.model.BookDTO;
import com.emami.bibliotheque.service.BookInventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book_management/")
public class BookInventoryController {

    BookInventoryService bookInventoryService;

    public BookInventoryController(BookInventoryService bookInventoryService) {
        this.bookInventoryService = bookInventoryService;
    }

    @GetMapping
    List<BookDTO> getAllBooks() {
        return bookInventoryService.findAllBooks();
    }

    @PostMapping
    ResponseEntity<BookDTO> addBook(@RequestBody BookDTO bookDTO) {
        return new ResponseEntity<BookDTO>(
                bookInventoryService.addBook(bookDTO), HttpStatus.OK
        );
    }
}
