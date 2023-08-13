package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.avis;
import com.pfe.marchepublic.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface avisRepository extends JpaRepository<avis, Long> {
    @Query("SELECT b FROM avis b WHERE LOWER(b.num_avis) LIKE %:searchTerm%")
    List<avis> findByNumContainingIgnoreCase(@Param("searchTerm") String searchTerm);

}
