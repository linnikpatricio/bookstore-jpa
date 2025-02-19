package com.bookstore.jpa.services;


import com.bookstore.jpa.entities.Book;
import com.bookstore.jpa.entities.Borrowing;
import com.bookstore.jpa.entities.Reader;
import com.bookstore.jpa.entities.enums.BookStatus;
import com.bookstore.jpa.repositories.BorrowingRepository;
import com.bookstore.jpa.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingSerivce {
    @Autowired
    private BorrowingRepository borrowingRepository;

    @Autowired
    private BookService bookService;

    @Autowired
    private ReaderService readerService;

    public List<Borrowing> findAll() {
        return borrowingRepository.findAll();
    }

    public Borrowing findById(Long id) {
        Optional<Borrowing> obj = borrowingRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Borrowing insert(Borrowing obj) {

        Book book = bookService.findById(obj.getBook().getId());
        if(book == null) {
            throw new RuntimeException("O Livro não existe!");
        }

        Reader reader = readerService.findById(obj.getReader().getId());
        if(reader == null) {
            throw new RuntimeException("O Cliente não existe!");
        }

        if(book.getBookStatus() == BookStatus.LOANED) {
            throw new RuntimeException("O Livro ja está emprestado!");
        }

        book.setBookStatus(BookStatus.LOANED);
        bookService.update(book);

        obj.setBook(book);
        obj.setReader(reader);


        return borrowingRepository.save(obj);
    }

    public void delete(Long id) {
        borrowingRepository.deleteById(id);
    }

}
