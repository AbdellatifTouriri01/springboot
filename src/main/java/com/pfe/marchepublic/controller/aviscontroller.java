package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.offre;
import com.pfe.marchepublic.services.avisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import java.io.*;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")

public class aviscontroller {
    @Autowired
    private avisService service;
    @GetMapping("/avis")
    public List<avis> list() {
        return service.listAll();
    }
    @GetMapping("/avis/{id}")
    public ResponseEntity<avis> get(@PathVariable Long id) {
        try {
            avis avis = service.get(id);
            return new ResponseEntity<avis>(avis, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<avis>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/avis/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/avis", consumes = {"application/xml","application/json"})

    public avis add(@RequestBody avis avis) {
        return service.save(avis);
    }
    @PutMapping("/avis/{id}")
    public avis update(@RequestBody avis avis, @PathVariable Long id) {
        return service.update( avis,id);

    }

    @GetMapping("/avis/search")
    public List<avis> search(@RequestParam("q") String query) {
        return service.search(query);
    }


}
