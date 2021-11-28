package com.eiv.pruebaingreso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Persona;
import com.eiv.pruebaingreso.entities.PersonaPK;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, PersonaPK> {
	@Query("SELECT p FROM Persona p WHERE p.nombre LIKE %:nombre% OR p.correoElectronico LIKE %:nombre%")
	public List<Persona> buscarPorNombreOmail(@Param("nombre") String nombre);

}
