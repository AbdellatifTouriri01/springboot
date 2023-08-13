package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.journales_list;
import com.pfe.marchepublic.entities.jury;
import com.pfe.marchepublic.repositories.journales_listRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class journales_listService {
    @Autowired
    private journales_listRepository repo;

    public List<journales_list> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   journales_list save(journales_list journales_list) {
        repo.save(journales_list);
        return journales_list;
    }

    public journales_list get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public journales_list update(journales_list journales_list,Long id)  {
        repo.findById(id).get();
        repo.save(journales_list);
        return journales_list;
    }
    public List<journales_list> search(String searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }
}
