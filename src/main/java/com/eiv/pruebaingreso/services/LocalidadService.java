package com.eiv.pruebaingreso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.pruebaingreso.entities.Localidad;
import com.eiv.pruebaingreso.repositories.LocalidadRepository;
import com.eiv.pruebaingreso.repositories.ProvinciaRepository;

@Service
public class LocalidadService {

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Transactional
	public Localidad crear(String nombre, Integer idProvincia, String codigoPostal) throws Exception {
		try {
			Localidad localidad = new Localidad();

			localidad.setNombre(nombre);
			localidad.setProvincia(provinciaRepository.findById(idProvincia).get());
			localidad.setCodigoPostal(codigoPostal);

			localidadRepository.save(localidad);

			return localidad;
		} catch (Exception e) {
			throw new Exception("Error al crear localidad");
		}
	}

	@Transactional
	public Localidad modificar(Integer id, String nombre, Integer idProvincia, String codigoPostal) throws Exception {
		try {
			Localidad localidad = localidadRepository.findById(id).get();

			localidad.setNombre(nombre);
			localidad.setProvincia(provinciaRepository.findById(idProvincia).get());
			localidad.setCodigoPostal(codigoPostal);

			localidadRepository.save(localidad);

			return localidad;
		} catch (Exception e) {
			throw new Exception("Error al modificar localidad");
		}
	}

	@Transactional
	public void eliminar(Integer id) throws Exception {
		try {
			Localidad localidad = localidadRepository.findById(id).get();

			localidadRepository.delete(localidad);

		} catch (Exception e) {
			throw new Exception("Error al eliminar localidad");
		}
	}
	
	@Transactional(readOnly = true)
	public List<Localidad> listarTodas() throws Exception {
		try {
			List<Localidad> localidades = localidadRepository.findAll();

			return localidades;
		} catch (Exception e) {
			throw new Exception("Error al listar localidades");
		}
	}
}
