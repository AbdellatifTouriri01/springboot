package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.decisions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface decisionsRepository extends JpaRepository<decisions,Long> {
    @Query("SELECT b FROM decisions b WHERE LOWER(b.avis) LIKE %:searchTerm%")
    List<decisions> findByNumContainingIgnoreCase(@Param("searchTerm") Long   searchTerm);

 }
