package com.emami.bibliotheque.repositories;

import com.emami.bibliotheque.restaurant.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
