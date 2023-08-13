package com.pfe.marchepublic.controller;

import com.fasterxml.jackson.databind.DatabindContext;
import com.pfe.marchepublic.entities.offre;
import com.pfe.marchepublic.entities.user;
import com.pfe.marchepublic.repositories.userRepository;
import com.pfe.marchepublic.services.userService;
import jakarta.persistence.criteria.Fetch;
import org.springframework.aop.ClassFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class usercontroller {
    @Autowired
    private userService service;
    @Autowired
    userRepository repo;
    @Autowired
    PasswordEncoder PasswordEncoder;
    @GetMapping("/user")
    public List<user> list() {
        return service.listAll();
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<user> get(@PathVariable Long id) {
        try {
            user user = service.get(id);
            return new ResponseEntity<user>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<user>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/user/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @PostMapping(value = "/user", consumes = {"application/xml","application/json"})
    public user add(@RequestBody user user) {
        return service.save(user);
    }
    @PutMapping("/user/{id}")
    public user update(@RequestBody user user, @PathVariable Long id) {
        return service.update( user,id);

    }


    @GetMapping("/user/search")
    public List<user> search(@RequestParam("q") String query) {
        return service.search(query);

    }

    @PostMapping("/login")
    public user login(@RequestBody user loginRequest) {
        if (service.isValidUser(loginRequest.getEmail(), loginRequest.getPassword())) {
                user user = service.getuser(loginRequest.getEmail());
            return user;
        } else {
            return  null;
        }
    }



}


