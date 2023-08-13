package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.concurrents;
import com.pfe.marchepublic.services.concurrentsService;
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
public class concurrentscontroller {
    @Autowired
    private concurrentsService service;
    @GetMapping("/concurrents")
    public List<concurrents> list() {
        return service.listAll();
    }
    @GetMapping("/concurrents/{id}")
    public ResponseEntity<concurrents> get(@PathVariable Long id) {
        try {
            concurrents concurrents = service.get(id);
            return new ResponseEntity<concurrents>(concurrents, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<concurrents>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/concurrents/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/concurrents", consumes = {"application/xml","application/json"})

    public concurrents add(@RequestBody concurrents concurrents) {
        return service.save(concurrents);
    }
    @PutMapping("/concurrents/{id}")
    public concurrents update(@RequestBody concurrents concurrents, @PathVariable Long id) {
        return service.update( concurrents,id);

    }





}
