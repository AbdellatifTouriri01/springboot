package com.pfe.marchepublic.controller;

import com.pfe.marchepublic.entities.journales_list;
import com.pfe.marchepublic.entities.jury;
import com.pfe.marchepublic.services.journales_listService;
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

public class journales_listcontroller {
    @Autowired
    private journales_listService service;
    @GetMapping("/journales_list")
    public List<journales_list> list() {
        return service.listAll();
    }
    @GetMapping("/journales_list/{id}")
    public ResponseEntity<journales_list> get(@PathVariable Long id) {
        try {
            journales_list journales_list = service.get(id);
            return new ResponseEntity<journales_list>(journales_list, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<journales_list>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/journales_list/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/journales_list", consumes = {"application/xml","application/json"})

    public journales_list add(@RequestBody journales_list journales_list) {
        return service.save(journales_list);
    }
    @PutMapping("/journales_list/{id}")
    public journales_list update(@RequestBody journales_list journales_list, @PathVariable Long id) {
        return service.update( journales_list,id);

    }


    @GetMapping("/journales_list/search")
    public List<journales_list> search(@RequestParam("q") String query) {
        return service.search(query);
    }

}
