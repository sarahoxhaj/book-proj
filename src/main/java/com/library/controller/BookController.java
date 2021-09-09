package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;


    @GetMapping(value = "/all")
    public ResponseEntity getAllBooks(){
        List<Book> allBooks = bookRepository.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping(value = "/getBook/{id}")
    public ResponseEntity getBook(@PathVariable int id){
        Book bookById = bookRepository.findBookById(id);
        return new ResponseEntity<>(bookById, HttpStatus.OK);
    }
}
