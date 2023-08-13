package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.pv_deux;
import com.pfe.marchepublic.repositories.pv_deuxRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class pv_deuxService {
    @Autowired
    private pv_deuxRepository repo;

    public List<pv_deux> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   pv_deux save(pv_deux pv_deux) {
        repo.save(pv_deux);
        return pv_deux;
    }

    public pv_deux get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public pv_deux update(pv_deux pv_deux,Long id)  {
        repo.findById(id).get();
        repo.save(pv_deux);
        return pv_deux;
    }
}
