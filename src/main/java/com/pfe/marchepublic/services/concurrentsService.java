package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.concurrents;
import com.pfe.marchepublic.repositories.concurrentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class concurrentsService {
    @Autowired
    private concurrentsRepository repo;

    public List<concurrents> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   concurrents save(concurrents concurrents) {
        repo.save(concurrents);
        return concurrents;
    }

    public concurrents get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public concurrents update(concurrents concurrents,Long id)  {
        repo.findById(id).get();
        repo.save(concurrents);
        return concurrents;
    }
}
