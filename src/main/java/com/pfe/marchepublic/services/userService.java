package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.user;
import com.pfe.marchepublic.repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class userService {
    @Autowired
    private userRepository repo;
    @Autowired
    PasswordEncoder PasswordEncoder;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    public List<user> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   user save(user user) {
        String hashedPassword = PasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        repo.save(user);
        return user;
    }

    public user get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public user update(user user,Long id)  {

        repo.findById(id).get();
        String hashedPassword = PasswordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);
        repo.save(user);
        return user;
    }
    public List<user> search(String searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }

    public boolean isValidUser(String email , String password) {
        user   user =  repo.findByEmail(email);
        return user != null && PasswordEncoder.matches(password, user.getPassword());
    }
    public user getuser(String email ) {
        return  repo.findByEmail(email);
    }


}
