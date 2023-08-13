package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.pv_un;
import com.pfe.marchepublic.services.pv_unService;
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

public class pv_uncontroller {
    @Autowired
    private pv_unService service;
    @GetMapping("/pv_un")
    public List<pv_un> list() {
        return service.listAll();
    }
    @GetMapping("/pv_un/{id}")
    public ResponseEntity<pv_un> get(@PathVariable Long id) {
        try {
            pv_un pv_un = service.get(id);
            return new ResponseEntity<pv_un>(pv_un, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<pv_un>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pv_un/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/pv_un", consumes = {"application/xml","application/json"})

    public pv_un add(@RequestBody pv_un pv_un) {
        return service.save(pv_un);
    }
    @PutMapping("/pv_un/{id}")
    public pv_un update(@RequestBody pv_un pv_un, @PathVariable Long id) {
        return service.update( pv_un,id);

    }



}
