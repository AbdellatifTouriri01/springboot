package com.pfe.marchepublic.repositories;

import com.pfe.marchepublic.entities.jury;
import com.pfe.marchepublic.entities.user;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface userRepository extends JpaRepository<user,Long> {
    @Query("SELECT b FROM user b WHERE LOWER(b.name) LIKE %:searchTerm%")
    List<user> findByNumContainingIgnoreCase(@Param("searchTerm") String searchTerm);
    user findByEmail(String email);

}
