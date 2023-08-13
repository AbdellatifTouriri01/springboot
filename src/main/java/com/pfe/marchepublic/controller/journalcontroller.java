package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.journal;
import com.pfe.marchepublic.services.journalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class journalcontroller {
    @Autowired
    private journalService service;
    @GetMapping("/journal")
    public List<journal> list() {
        return service.listAll();
    }
    @GetMapping("/journal/{id}")
    public ResponseEntity<journal> get(@PathVariable Long id) {
        try {
            journal journal = service.get(id);
            return new ResponseEntity<journal>(journal, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<journal>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/journal/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/journal", consumes = {"application/xml","application/json"})

    public journal add(@RequestBody journal journal) {
        return service.save(journal);
    }
    @PutMapping("/journal/{id}")
    public journal update(@RequestBody journal journal, @PathVariable Long id) {
        return service.update( journal,id);

    }



}
