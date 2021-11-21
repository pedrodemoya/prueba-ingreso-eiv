package com.eiv.pruebaingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Localidad;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Integer> {

}
