package com.bookstore.jpa.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name = "tb_borrowing")
public class Borrowing implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "id_reader")
    private Reader reader;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Borrowing() {

    }

    public Borrowing(long id, Book book, Reader reader, LocalDate loanDate, LocalDate returnDate) {
        this.id = id;
        this.book = book;
        this.reader = reader;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Borrowing borrowing = (Borrowing) o;
        return id == borrowing.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
