package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.jury;
import com.pfe.marchepublic.entities.offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface juryRepository extends JpaRepository<jury,Long> {

    @Query("SELECT b FROM jury b WHERE LOWER(b.Nom) LIKE %:searchTerm%")
    List<jury> findByNumContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
