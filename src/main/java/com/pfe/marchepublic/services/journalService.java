package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.journal;
import com.pfe.marchepublic.repositories.journalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class journalService {
    @Autowired
    private journalRepository repo;

    public List<journal> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   journal save(journal journal) {
        repo.save(journal);
        return journal;
    }

    public journal get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public journal update(journal journal,Long id)  {
        repo.findById(id).get();
        repo.save(journal);
        return journal;
    }
}
