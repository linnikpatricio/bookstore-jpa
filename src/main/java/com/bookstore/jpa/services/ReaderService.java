package com.bookstore.jpa.services;

import com.bookstore.jpa.entities.Reader;
import com.bookstore.jpa.repositories.ReaderRepository;
import com.bookstore.jpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReaderService {
    @Autowired
    private ReaderRepository repository;

    public List<Reader> findAll() {
        return repository.findAll();
    }

    public Reader findById(Long id) {
        Optional<Reader> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Reader insert(Reader obj) {
        return repository.save(obj);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
