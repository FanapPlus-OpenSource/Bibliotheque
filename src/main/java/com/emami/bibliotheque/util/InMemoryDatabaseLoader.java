package com.emami.bibliotheque.util;


import com.emami.bibliotheque.entity.Book;
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
//            //I am a User
//            User hessam = userRepository.findById(1L).get();
//            //I can see all the books
//            List<Book> books = bookRepository.findAll();
//            //I pick a book
//            Book pickedBook = books.get(1);
            Book book = new Book(null, "", 123);
            bookRepository.save(book);
//            hessam.addBook(pickedBook);

//            userRepository.save(hessam);
//            //Server checks if the book is currently available to borrow
//            //book and user each has a reference to the UserBook Entity
//            Set<UserBook> userBooks = pickedBook.getUserBooks();
//            boolean isBookIsReturned = userBooks.stream().allMatch(UserBook::getReturned);
//            if (isBookIsReturned || userBooks.isEmpty()) {
//                //The Book is available for borrow
//                //Compose a UserBookEntity and persist it
//                UserBook userBook = new UserBook(pickedBook, hessam);
//                hessam.addUserBook(userBook);
//                userRepository.save(hessam);
//            }
        };
    }

}