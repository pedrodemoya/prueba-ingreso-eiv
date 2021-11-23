package com.eiv.pruebaingreso.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Persona;
import com.eiv.pruebaingreso.entities.PersonaPK;


//Ver tipo variable id
@Repository
public interface PersonaRepository extends JpaRepository<Persona, PersonaPK> {
	
	@Query("SELECT p FROM Persona p WHERE p.nombreApellido LIKE %:busqueda% OR l.correoElectronico LIKE %:busqueda%")
	public List<Persona> buscarPorNombreOmail (@Param("busqueda") String busqueda);
	
	@Query("SELECT p FROM Persona p WHERE p.localidad LIKE %:busqueda% OR l.localidad.provincia LIKE %:busqueda%")
	public List<Persona> buscarPorLocalidadOprovincia (@Param("busqueda") String busqueda);
	
}
