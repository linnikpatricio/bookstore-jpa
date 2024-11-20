package com.bookstore.jpa.repositories;

import com.bookstore.jpa.entities.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader,Long> {
}
