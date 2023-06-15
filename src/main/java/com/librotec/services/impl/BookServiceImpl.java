package com.librotec.services.impl;

import com.librotec.entity.Book;
import com.librotec.repository.BookRepository;
import com.librotec.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

////*************  LA CAPA DE SERVICIOS REALIZARA LAS OPERACIONES PERTINENETES DE LA LOGICA DEL NEGOCIO
// Y HARA EL ENLACE CON LA BASE DE DATOS POR MEDIO DEL REPOSITORIO
@Service
public class BookServiceImpl implements BookService {


    @Autowired
    BookRepository bookRepository;

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book createBook(Book book) {

        return bookRepository.save(book);
    }

    @Override
    public void updateBook(Book book) {
        bookRepository.save(book);

    }

    @Override
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }
}
