package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.user;
import com.pfe.marchepublic.repositories.avisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class avisService {
    @Autowired
    private avisRepository repo;

    public List<avis> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   avis save(avis avis) {
        repo.save(avis);
        return avis;
    }

    public avis get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public avis update(avis avis,Long id)  {
        repo.findById(id).get();
        repo.save(avis);
        return avis;
    }
    public List<avis> search(String searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }
}
