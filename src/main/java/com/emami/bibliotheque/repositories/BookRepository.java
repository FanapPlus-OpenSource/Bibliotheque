package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
