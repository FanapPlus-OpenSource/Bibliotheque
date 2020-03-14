package com.emami.bibliotheque;

import com.emami.bibliotheque.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
