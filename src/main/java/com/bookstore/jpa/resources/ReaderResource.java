package com.bookstore.jpa.resources;

import com.bookstore.jpa.entities.Reader;
import com.bookstore.jpa.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/readers")
public class ReaderResource {
    @Autowired
    private ReaderService readerService;

    @GetMapping
    public ResponseEntity<List<Reader>> findAll() {
        List<Reader> list = readerService.findAll();
        return ResponseEntity.ok().body(list);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Reader> findById(@PathVariable Long id) {
        Reader obj = readerService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
    @PostMapping
    public ResponseEntity<Reader> insert(@RequestBody Reader obj) {
        obj = readerService.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        readerService.delete(id);
        return ResponseEntity.noContent().build();
    }


}
