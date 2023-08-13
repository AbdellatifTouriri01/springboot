package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.pv_deux;
import com.pfe.marchepublic.services.pv_deuxService;
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

public class pv_deuxcontroller {
    @Autowired
    private pv_deuxService service;
    @GetMapping("/pv_deux")
    public List<pv_deux> list() {
        return service.listAll();
    }
    @GetMapping("/pv_deux/{id}")
    public ResponseEntity<pv_deux> get(@PathVariable Long id) {
        try {
            pv_deux pv_deux = service.get(id);
            return new ResponseEntity<pv_deux>(pv_deux, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<pv_deux>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pv_deux/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/pv_deux", consumes = {"application/xml","application/json"})

    public pv_deux add(@RequestBody pv_deux pv_deux) {
        return service.save(pv_deux);
    }
    @PutMapping("/pv_deux/{id}")
    public pv_deux update(@RequestBody pv_deux pv_deux, @PathVariable Long id) {
        return service.update( pv_deux,id);

    }



}
