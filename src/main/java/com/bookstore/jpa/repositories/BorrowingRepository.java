package com.bookstore.jpa.repositories;

import com.bookstore.jpa.entities.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing,Long> {
}
