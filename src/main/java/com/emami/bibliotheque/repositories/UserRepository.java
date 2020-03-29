package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
