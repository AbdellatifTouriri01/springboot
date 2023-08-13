package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.decisions;
import com.pfe.marchepublic.repositories.decisionsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class decisionsService {
    @Autowired
    private decisionsRepository repo;

    public List<decisions> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   decisions save(decisions decisions) {
        repo.save(decisions);
        return decisions;
    }

    public decisions get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public decisions update(decisions decisions,Long id)  {
        repo.findById(id).get();
        repo.save(decisions);
        return decisions;
    }
    public List<decisions> search(Long searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }

 }
