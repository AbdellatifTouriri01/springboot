package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.pv_trois;
import com.pfe.marchepublic.repositories.pv_troisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class pv_troisService {
    @Autowired
    private pv_troisRepository repo;

    public List<pv_trois> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   pv_trois save(pv_trois pv_trois) {
        repo.save(pv_trois);
        return pv_trois;
    }

    public pv_trois get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public pv_trois update(pv_trois pv_trois,Long id)  {
        repo.findById(id).get();
        repo.save(pv_trois);
        return pv_trois;
    }
}
