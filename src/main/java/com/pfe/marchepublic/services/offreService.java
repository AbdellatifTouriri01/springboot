package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.offre;
import com.pfe.marchepublic.repositories.offreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class offreService {
    @Autowired
    private offreRepository repo;

    public List<offre> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   offre save(offre offre) {
        repo.save(offre);
        return offre;
    }

    public offre get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public offre update(offre offre,Long id)  {
        repo.findById(id).get();
        repo.save(offre);
        return offre;
    }
    public List<offre> search(String searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }
}
