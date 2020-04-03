package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);

    Optional<List<Book>> findBooksByAuthor(String author);

    Optional<List<Book>> findBooksByTitleLike(String title);

    Optional<Book> findBookByIsbn(Long isbn);
}
