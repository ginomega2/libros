package com.librotec.controllers;

import com.librotec.entity.Book;
import com.librotec.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/mvc")         //************    http://localhost:8066/mvc
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/index")            //************    http://localhost:8066/mvc/index
    public String getAllBooks(Model model){
        List<Book> books = bookService.findAllBooks();
        model.addAttribute("books",books);
        return "index";
    }
}
