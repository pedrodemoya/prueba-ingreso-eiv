package com.eiv.pruebaingreso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eiv.pruebaingreso.entities.Provincia;

@Repository
public interface ProvinciaRepository extends JpaRepository<Provincia, Integer> {
		
}
