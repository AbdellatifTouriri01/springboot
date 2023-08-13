package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.concurent_list;
import com.pfe.marchepublic.services.concurent_listService;
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

public class concurent_listcontroller {
    @Autowired
    private concurent_listService service;
    @GetMapping("/concurent_list")
    public List<concurent_list> list() {
        return service.listAll();
    }
    @GetMapping("/concurent_list/{id}")
    public ResponseEntity<concurent_list> get(@PathVariable Long id) {
        try {
            concurent_list concurent_list = service.get(id);
            return new ResponseEntity<concurent_list>(concurent_list, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<concurent_list>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/concurent_list/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/concurent_list", consumes = {"application/xml","application/json"})

    public concurent_list add(@RequestBody concurent_list concurent_list) {
        return service.save(concurent_list);
    }
    @PutMapping("/concurent_list/{id}")
    public concurent_list update(@RequestBody concurent_list concurent_list, @PathVariable Long id) {
        return service.update( concurent_list,id);

    }



    @GetMapping("/concurent_list/search")
    public List<concurent_list> search(@RequestParam("q") String query) {
        return service.search(query);
    }


}
