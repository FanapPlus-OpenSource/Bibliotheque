package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findBookByTitle(String title);

    Optional<Set<Book>> findBooksByAuthor(String author);

    Optional<Set<Book>> findBooksByTitle(String title);
}
