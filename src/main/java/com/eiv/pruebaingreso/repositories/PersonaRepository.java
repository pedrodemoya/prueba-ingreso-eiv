package com.eiv.pruebaingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Persona;
import com.eiv.pruebaingreso.entities.PersonaPK;


//Ver tipo variable id
@Repository
public interface PersonaRepository extends JpaRepository<Persona, PersonaPK> {
	
}
