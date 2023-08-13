package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.decisions;
import com.pfe.marchepublic.services.decisionsService;
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

public class decisionscontroller {
    @Autowired
    private decisionsService service;
    @GetMapping("/decisions")
    public List<decisions> list() {
        return service.listAll();
    }
    @GetMapping("/decisions/{id}")
    public ResponseEntity<decisions> get(@PathVariable Long id) {
        try {
            decisions decisions = service.get(id);
            return new ResponseEntity<decisions>(decisions, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<decisions>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/decisions/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/decisions", consumes = {"application/xml","application/json"})

    public decisions add(@RequestBody decisions decisions) {
        return service.save(decisions);
    }
    @PutMapping("/decisions/{id}")
    public decisions update(@RequestBody decisions decisions, @PathVariable Long id) {
        return service.update( decisions,id);

    }


    @GetMapping("/decisions/search")
    public List<decisions> search(@RequestParam("q") Long query) {
        return service.search(query);
    }



}
