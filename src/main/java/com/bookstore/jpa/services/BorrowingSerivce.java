package com.bookstore.jpa.services;


import com.bookstore.jpa.entities.Borrowing;
import com.bookstore.jpa.repositories.BorrowingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingSerivce {
    @Autowired
    private BorrowingRepository borrowingRepository;

    public List<Borrowing> findAll() {
        return borrowingRepository.findAll();
    }

    public Borrowing findById(Long id) {
        Optional<Borrowing> obj = borrowingRepository.findById(id);
        return obj.get();
    }

    public Borrowing insert(Borrowing obj) {
        return borrowingRepository.save(obj);
    }
}
