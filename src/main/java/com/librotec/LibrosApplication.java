package com.librotec;

import com.librotec.entity.Book;
import com.librotec.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LibrosApplication implements ApplicationRunner {

    @Autowired
    BookService bookService;

    public static void main(String[] args) {
        SpringApplication.run(LibrosApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Book> books = bookService.findAllBooks();
        if (books != null && books.isEmpty()) {

            Book book1 = Book.builder().name("java").desciption("java").price(123).build();
            Book book2 = Book.builder().name("java ee").desciption("java ee").price(321).build();
            Book book3 = Book.builder().name("c++").desciption("c++").price(654).build();
            Book book4 = Book.builder().name("c#").desciption("c#").price(87).build();

            Arrays.asList(book1, book2, book3, book4).forEach(book -> bookService.createBook(book));

            System.out.println("libros agregados en la base de datos");
        }
    }
}