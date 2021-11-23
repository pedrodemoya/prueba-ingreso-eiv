package com.eiv.pruebaingreso.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.pruebaingreso.entities.Localidad;
import com.eiv.pruebaingreso.entities.Persona;
import com.eiv.pruebaingreso.entities.PersonaPK;
import com.eiv.pruebaingreso.enums.Genero;
import com.eiv.pruebaingreso.repositories.LocalidadRepository;
import com.eiv.pruebaingreso.repositories.PersonaRepository;
import com.eiv.pruebaingreso.repositories.TipoDocumentoRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;

	@Autowired
	private LocalidadRepository localidadRepository;
	
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Transactional
	public Persona crear(Integer idTipoDocumento, Integer numeroDocumento, String nombreApellido,
			Date fechaNacimiento, String genero, String correoElectronico, byte[] foto,
			Integer idLocalidad, String codigoPostal) throws Exception {

		try {
			PersonaPK personaPK = new PersonaPK(tipoDocumentoRepository.findById(idTipoDocumento).get(), numeroDocumento);

			Persona persona = new Persona();

			persona.setPersonaPK(personaPK);
			persona.setNombrApellido(nombreApellido);
			persona.setFechNacimiento(fechaNacimiento);
			persona.setGenero(Genero.valueOf(genero));
			persona.setEsArgentino(true);
			persona.setCorreoElectronico(correoElectronico);
			persona.setFotoCara(foto);

			Localidad localidad = localidadRepository.findById(idLocalidad).get();
			persona.setLocalidad(localidad);

			if (codigoPostal == null) {
				persona.setCodigoPostal(localidad.getCodigoPostal());
			} else {
				persona.setCodigoPostal(codigoPostal);
			}

			personaRepository.save(persona);

			return persona;
		} catch (Exception e) {
			throw new Exception("Error al crear persona");
		}
	}
	
	@Transactional(readOnly = true)
	public List<Persona> listarTodas() throws Exception {
		try {
			List<Persona> personas = personaRepository.findAll();
			
			return personas;
		} catch (Exception e) {
			throw new Exception("Error al listar personas");
		}
	}
}
