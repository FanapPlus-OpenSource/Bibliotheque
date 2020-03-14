package com.emami.bibliotheque.util;


import com.emami.bibliotheque.BookRepository;
import com.emami.bibliotheque.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Slf4j
public class InMemoryDatabaseLoader {

    @Bean
    CommandLineRunner initDb(BookRepository repository) {
        return args -> {
            Date date = new Date();

            log.info("Repository " + repository.save(new Book(11, "Alive", "Hessam Emami", new Date())));
            log.info("Repository " + repository.save(new Book(12, "Not Alive", "Shahrad Emami", new Date())));
            log.info("Repository " + repository.save(new Book(13, "Dead", "George Bush", new Date())));
        };
    }
}