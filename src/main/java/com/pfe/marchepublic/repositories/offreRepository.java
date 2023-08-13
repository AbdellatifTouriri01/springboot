package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface offreRepository extends JpaRepository<offre, Long> {
 @Query("SELECT b FROM offre b WHERE LOWER(b.Num) LIKE %:searchTerm%")
 List<offre> findByNumContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
