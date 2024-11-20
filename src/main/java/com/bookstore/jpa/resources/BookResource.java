package com.bookstore.jpa.resources;

import com.bookstore.jpa.entities.Book;
import com.bookstore.jpa.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/books")
public class BookResource {
    @Autowired
    private BookService bookService;
    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        List<Book> list = bookService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        Book obj = bookService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody Book obj) {
        obj = bookService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
