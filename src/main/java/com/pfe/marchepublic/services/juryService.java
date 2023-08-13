package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.jury;
import com.pfe.marchepublic.entities.offre;
import com.pfe.marchepublic.repositories.juryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class juryService {
    @Autowired
    private juryRepository repo;

    public List<jury> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   jury save(jury jury) {
        repo.save(jury);
        return jury;
    }

    public jury get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public jury update(jury jury,Long id)  {
        repo.findById(id).get();
        repo.save(jury);
        return jury;
    }

    public List<jury> search(String searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }
}
