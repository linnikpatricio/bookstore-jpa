package com.bookstore.jpa.services;

import com.bookstore.jpa.entities.Book;
import com.bookstore.jpa.entities.enums.BookStatus;
import com.bookstore.jpa.repositories.BookRepository;
import com.bookstore.jpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Book insert(Book obj) {

        if(obj.getBookStatus() == null) {
            obj.setBookStatus(BookStatus.AVAILABLE);
        }
        return repository.save(obj);
    }


    public Book update(Book book) {
        return repository.save(book);
    }

    public void delete(Long id) {
        if(!repository.existsById(id)) {
            throw new ResourceNotFoundException(id);
        }
        repository.deleteById(id);
    }
}
