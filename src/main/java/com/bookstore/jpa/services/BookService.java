package com.bookstore.jpa.services;

import com.bookstore.jpa.entities.Book;
import com.bookstore.jpa.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }

    public Book insert(Book obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}
