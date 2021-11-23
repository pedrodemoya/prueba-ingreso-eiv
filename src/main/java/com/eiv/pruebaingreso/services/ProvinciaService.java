package com.eiv.pruebaingreso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.pruebaingreso.entities.Provincia;
import com.eiv.pruebaingreso.enums.Region;
import com.eiv.pruebaingreso.repositories.ProvinciaRepository;

@Service
public class ProvinciaService {

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Transactional
	public Provincia crear(String nombre, String region) throws Exception {
		try {
			Provincia provincia = new Provincia();

			provincia.setNombre(nombre);
			provincia.setRegion(Region.valueOf(region));

			provinciaRepository.save(provincia);

			return provincia;
		} catch (Exception e) {
			throw new Exception("Error al crear provincia");
		}
	}

	@Transactional
	public Provincia modificar(Integer id, String nombre, String region) throws Exception {
		try {
			Provincia provincia = provinciaRepository.findById(id).get();
			provincia.setNombre(nombre);
			provincia.setRegion(Region.valueOf(region));

			provinciaRepository.save(provincia);

			return provincia;
		} catch (Exception e) {
			throw new Exception("Error al modificar provincia");
		}
	}
	
	@Transactional
	public void eliminar(Integer id) throws Exception{
		try {
			Provincia provincia = provinciaRepository.findById(id).get();
			
			provinciaRepository.delete(provincia);
			
		} catch (Exception e) {
			throw new Exception("Error al eliminar provincia");
		}
	}
	
	@Transactional(readOnly = true)
	public List<Provincia> listarTodas () throws Exception{
		try {
			List<Provincia> provincias = provinciaRepository.findAll();
			
			return provincias;
		} catch (Exception e) {
			throw new Exception("Error al listar provincias");
		}
	}
}
