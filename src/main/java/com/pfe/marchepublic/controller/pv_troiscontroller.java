package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.pv_trois;
import com.pfe.marchepublic.services.pv_troisService;
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

public class pv_troiscontroller {
    @Autowired
    private pv_troisService service;
    @GetMapping("/pv_trois")
    public List<pv_trois> list() {
        return service.listAll();
    }
    @GetMapping("/pv_trois/{id}")
    public ResponseEntity<pv_trois> get(@PathVariable Long id) {
        try {
            pv_trois pv_trois = service.get(id);
            return new ResponseEntity<pv_trois>(pv_trois, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<pv_trois>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/pv_trois/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/pv_trois", consumes = {"application/xml","application/json"})

    public pv_trois add(@RequestBody pv_trois pv_trois) {
        return service.save(pv_trois);
    }
    @PutMapping("/pv_trois/{id}")
    public pv_trois update(@RequestBody pv_trois pv_trois, @PathVariable Long id) {
        return service.update( pv_trois,id);

    }



}
