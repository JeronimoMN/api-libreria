package com.api.apilLibreria.controller;

import com.api.apilLibreria.model.BookModel;
import com.api.apilLibreria.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/library")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ArrayList<BookModel> getBooks() {
        return this.bookService.getAllBooks();
    }

    @PostMapping("/books")
    public BookModel createBook(@RequestBody BookModel book) {
        return this.bookService.saveBook(book);
    }

    @GetMapping(path = "/{id}")
    public Optional<BookModel> getBookById(@PathVariable("id") Long id) {
        return this.bookService.getBookById(id);
    }

    @PutMapping(path = "/{id}")
    public BookModel updateBookById(@PathVariable("id") Long id, @RequestBody BookModel rq) {
        return this.bookService.updateBook(rq, id);
    }

    @DeleteMapping("/{id}")
    public String deleteBookById(@PathVariable("id") Long id) {
        boolean ok = this.bookService.deleteBook(id);
        if(ok){
            return "Book with id: " + id + " deleted successful" ;
        }else {
            return "Error, we couldn't delete book with id: " + id;
        }
    }
}
