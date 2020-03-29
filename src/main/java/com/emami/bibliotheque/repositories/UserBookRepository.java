package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.entity.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserBookRepository extends JpaRepository<UserBook, Long> {
}
