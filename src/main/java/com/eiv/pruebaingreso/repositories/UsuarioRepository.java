package com.eiv.pruebaingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Usuario;

//Ver tipo de dato ID
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
	
}
