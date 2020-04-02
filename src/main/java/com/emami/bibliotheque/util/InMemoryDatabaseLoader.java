package com.emami.bibliotheque.util;


import com.emami.bibliotheque.repositories.BookRepository;
import com.emami.bibliotheque.repositories.UserBookRepository;
import com.emami.bibliotheque.repositories.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;


@Configuration
@Slf4j
public class InMemoryDatabaseLoader {

    @Bean
    CommandLineRunner initDb(EntityManager em, BookRepository bookRepository, UserRepository userRepository, UserBookRepository userBookRepository) {
        return args -> {
        };
    }

}