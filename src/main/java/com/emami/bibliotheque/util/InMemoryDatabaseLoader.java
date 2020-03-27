package com.emami.bibliotheque.util;


import com.emami.bibliotheque.restaurant.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
@Slf4j
public class InMemoryDatabaseLoader {

    @Autowired
    EntityManager em;

    @Bean
    CommandLineRunner initDb() {
        return args -> {
            Category category = new Category();
            category.setDescription("Italian");
//            em.persist(category);

        };
    }

}