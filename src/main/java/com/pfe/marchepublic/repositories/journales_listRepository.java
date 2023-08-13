package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.journales_list;
import com.pfe.marchepublic.entities.jury;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface journales_listRepository extends JpaRepository<journales_list,Long> {
    @Query("SELECT b FROM journales_list b WHERE LOWER(b.nome_journale) LIKE %:searchTerm%")
    List<journales_list> findByNumContainingIgnoreCase(@Param("searchTerm") String searchTerm);
}
