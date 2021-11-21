package com.eiv.pruebaingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Persona;


//Ver tipo variable id
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
	
}
