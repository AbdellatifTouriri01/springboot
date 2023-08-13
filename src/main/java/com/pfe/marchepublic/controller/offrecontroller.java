package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.offre;
import com.pfe.marchepublic.services.offreService;
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
public class offrecontroller {
    @Autowired
    private offreService service;
    @GetMapping("/offre")
    public List<offre> list() {
        return service.listAll();
    }
    @GetMapping("/offre/{id}")
    public ResponseEntity<offre> get(@PathVariable Long id) {
        try {
            offre offre = service.get(id);
            return new ResponseEntity<offre>(offre, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<offre>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/offre/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/offre", consumes = {"application/xml","application/json"})

    public offre add(@RequestBody offre offre) {
       return service.save(offre);
    }
    @PutMapping("/offre/{id}")
    public offre update(@RequestBody offre offre, @PathVariable Long id) {
        return service.update( offre,id);

    }

    @GetMapping("/offre/search")
    public List<offre> search(@RequestParam("q") String query) {
        return service.search(query);
    }

}
