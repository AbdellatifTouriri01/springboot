package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.pv_un;
import com.pfe.marchepublic.repositories.pv_unRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class pv_unService {
    @Autowired
    private pv_unRepository repo;

    public List<pv_un> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   pv_un save(pv_un pv_un) {
        repo.save(pv_un);
        return pv_un;
    }

    public pv_un get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public pv_un update(pv_un pv_un,Long id)  {
        repo.findById(id).get();
        repo.save(pv_un);
        return pv_un;
    }
}
