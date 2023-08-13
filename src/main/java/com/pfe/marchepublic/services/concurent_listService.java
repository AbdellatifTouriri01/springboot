package com.pfe.marchepublic.services;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.concurent_list;
import com.pfe.marchepublic.repositories.concurent_listRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class concurent_listService {
    @Autowired
    private concurent_listRepository repo;

    public List<concurent_list> listAll() {
        return repo.findAll(
                Sort.by(Sort.Direction.DESC, "id")
        );
    }
    public   concurent_list save(concurent_list concurent_list) {
        repo.save(concurent_list);
        return concurent_list;
    }

    public concurent_list get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public concurent_list update(concurent_list concurent_list,Long id)  {
        repo.findById(id).get();
        repo.save(concurent_list);
        return concurent_list;
    }
    public List<concurent_list> search(String searchTerm) {
        return repo.findByNumContainingIgnoreCase(searchTerm);

    }
}
