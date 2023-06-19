package com.librotec.controllers;

import com.librotec.entity.Book;
import com.librotec.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/rest")         //************    http://localhost:8066/rest
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/index")            //************    http://localhost:8066/rest/index
    public String getAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books );
        return "index";
    }

    @PostMapping("/update")
    public String update(Book book){
        bookService.updateBook(book);
        return "redirect:/rest/index";
    }

    @PostMapping("/addBook")           //************    http://localhost:8066/rest/addBook          POST
    public String addNewBook(Book book){
        Book resultado = bookService.createBook(book);
        return "redirect:/rest/index";
    }

    @RequestMapping({"/edit/{id}"})  //************    http://localhost:8066/rest/edit
                                                    //           http://localhost:8066/rest/edit/1   GET
    public String editBook(Model model, @PathVariable("id")  Optional<Long> id){
//        Book book= new Book();
//        model.addAttribute("book",book);

            Optional<Book> book= bookService.findBookById(id.get());

            model.addAttribute("book",book);


        return "add-edit-book";

    }

    @RequestMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id){
        bookService.deleteBook(id);
        return "redirect:/rest/index";
    }

}
