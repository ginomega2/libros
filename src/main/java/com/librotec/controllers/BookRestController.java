package com.librotec.controllers;


import com.librotec.entity.Book;
import com.librotec.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")        //********      http://localhost:8066/api/book
public class BookRestController {


    @Autowired
    private BookService bookService;

    @GetMapping("/all")          //********      http://localhost:8066/api/book/all         GET
    public ResponseEntity<List<Book>> getAllBooks(){
        final List<Book> books = bookService.findAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping("/add")             //********      http://localhost:8066/api/book/add         POST
    public ResponseEntity<Book> addNewBook(@RequestBody Book book){
        Book bookInserted = bookService.createBook(book);
        if (bookInserted==null){// libro no encontrado
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
//        return new ResponseEntity<>(HttpStatus.ACCEPTED);
        return new ResponseEntity<>(bookInserted,HttpStatus.ACCEPTED); //
    }

    @PostMapping("/update")             //********      http://localhost:8066/api/book/update         POST
    public ResponseEntity updateBook(@RequestBody Book book){
        bookService.updateBook(book);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")           //********      http://localhost:8066/api/book/delete/1         POST
    public ResponseEntity deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }




}
