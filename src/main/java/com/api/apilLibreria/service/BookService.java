package com.api.apilLibreria.service;

import com.api.apilLibreria.model.BookModel;
import com.api.apilLibreria.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    IBookRepository bookRepository;

    public ArrayList<BookModel> getAllBooks() {
        return (ArrayList<BookModel>) bookRepository.findAll();
    }

    public BookModel saveBook(BookModel book){
        return bookRepository.save(book);
    }

    public Optional<BookModel> getBookById(Long id){
        return bookRepository.findById(id);
    }

    public BookModel updateBook(BookModel rq, Long id){
        BookModel book = bookRepository.findById(id).get();

        book.setAuthor(rq.getAuthor());
        book.setTitle(rq.getTitle());
        book.setIsbn(rq.getIsbn());
        book.setPublisher(rq.getPublisher());

        return book;
    }

    public Boolean deleteBook(Long id){
        try {
            bookRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }
}