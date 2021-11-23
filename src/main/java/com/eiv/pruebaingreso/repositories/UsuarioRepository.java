package com.eiv.pruebaingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.PersonaPK;
import com.eiv.pruebaingreso.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, PersonaPK> {

	Usuario findByUsuario(String usuario);

}
