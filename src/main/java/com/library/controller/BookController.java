package com.library.controller;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/book")
//localhost:8080/book
public class BookController {
    @Autowired
    BookRepository bookRepository;


    @GetMapping(value = "/all")
    //localhost:8080/book/all
    public ResponseEntity getAllBooks() {
        List<Book> allBooks = bookRepository.findAllBooks();
        return new ResponseEntity<>(allBooks, HttpStatus.OK);
    }

    @GetMapping(value = "/getBook/{id}")
    //localhost:8080/book/getBook/13
    public ResponseEntity getBook(@PathVariable int id) {
        Book bookById = bookRepository.findBookById(id);
        return new ResponseEntity<>(bookById, HttpStatus.OK);
    }


    @GetMapping(value = "/getBookByAuthor/{author}")
    //localhost:8080/book/getBookByAuthor/autori
    public ResponseEntity getBookAuthor(@PathVariable String author) {
        List<Book> bookByAuthor = bookRepository.getAllBooksFromAuthor(author);
        return new ResponseEntity<>(bookByAuthor, HttpStatus.OK);
    }


    @DeleteMapping(value = "/deleteBook/{isbn}")
    //localhost:8080/book/deleteBook/isbn
    public ResponseEntity deleteBookByIsbn(@PathVariable int isbn) {
        boolean fshi = bookRepository.deleteBookByIsbn(isbn);
        if (!fshi) {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(fshi, HttpStatus.OK);
    }


    @GetMapping(value = "/startsWith/{st}")
    //localhost:8080/book/startsWith/stringu
    public ResponseEntity getAllBooksStartingWith(@PathVariable String st) {
        List<Book> bookStartsWith = bookRepository.getAllBooksStartingWith(st);
        return new ResponseEntity<>(bookStartsWith, HttpStatus.OK);
    }


    @PostMapping(value = "/insertBook")
    //localhost:8080/book/insertBook/
    public ResponseEntity insertBook(@RequestBody Book book) {
        boolean shto = bookRepository.insertBook(book);
        return new ResponseEntity<>(shto, HttpStatus.OK);
    }


    @PutMapping(value = "/updateBook1")
    //localhost:8080/book/updateBook1
    public ResponseEntity updateBook1(@RequestBody Book book) {
        boolean up = bookRepository.updateBook(book);
        return new ResponseEntity<>(up, HttpStatus.OK);
    }


}
