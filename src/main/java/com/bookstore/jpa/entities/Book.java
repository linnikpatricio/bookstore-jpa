package com.bookstore.jpa.entities;

import com.bookstore.jpa.entities.enums.BookStatus;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "tb_book")
public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String author;
    private String genre;
    private LocalDate yearOfPublication;
    private Integer booksAvailable;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus;
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Borrowing> borrowingList = new ArrayList<>();

    public Book() {

    }

    public Book(Long id, String title, String author, String genre, LocalDate yearOfPublication, Integer booksAvailable, BookStatus bookStatus) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearOfPublication = yearOfPublication;
        this.booksAvailable = booksAvailable;
        this.bookStatus = bookStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(LocalDate yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public Integer getBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(Integer booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public BookStatus getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(BookStatus bookStatus) {
        this.bookStatus = bookStatus;
    }

    public List<Borrowing> getBorrowingList() {
        return borrowingList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
