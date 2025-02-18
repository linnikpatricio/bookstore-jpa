package com.bookstore.jpa.resources;

import com.bookstore.jpa.entities.Book;
import com.bookstore.jpa.entities.Borrowing;
import com.bookstore.jpa.services.BookService;
import com.bookstore.jpa.services.BorrowingSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/borrowings")
public class BorrowingResource {
    @Autowired
    private BorrowingSerivce borrowingSerivce;

    @GetMapping
    public ResponseEntity<List<Borrowing>> findAll() {
        List<Borrowing> list = borrowingSerivce.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Borrowing> findById(@PathVariable Long id) {
        Borrowing obj = borrowingSerivce.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Borrowing> insert(@RequestBody Borrowing obj) {
        obj = borrowingSerivce.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        borrowingSerivce.delete(id);
        return ResponseEntity.noContent().build();
    }


}
