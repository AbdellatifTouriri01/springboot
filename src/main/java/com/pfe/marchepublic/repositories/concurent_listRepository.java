package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.concurent_list;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface concurent_listRepository extends JpaRepository<concurent_list, Long> {

    @Query("SELECT b FROM concurent_list b WHERE LOWER(b.Nom_gerant) LIKE %:searchTerm%")
    List<concurent_list> findByNumContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
