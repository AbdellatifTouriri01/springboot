package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.jury;
import com.pfe.marchepublic.entities.offre;
import com.pfe.marchepublic.services.juryService;
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

public class jurycontroller {
    @Autowired
    private juryService service;
    @GetMapping("/jury")
    public List<jury> list() {
        return service.listAll();
    }
    @GetMapping("/jury/{id}")
    public ResponseEntity<jury> get(@PathVariable Long id) {
        try {
            jury jury = service.get(id);
            return new ResponseEntity<jury>(jury, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<jury>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/jury/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/jury", consumes = {"application/xml","application/json"})

    public jury add(@RequestBody jury jury) {
        return service.save(jury);
    }
    @PutMapping("/jury/{id}")
    public jury update(@RequestBody jury jury, @PathVariable Long id) {
        return service.update( jury,id);

    }
    @GetMapping("/jury/search")
    public List<jury> search(@RequestParam("q") String query) {
        return service.search(query);
    }





}
