package com.eiv.pruebaingreso.services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

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
			LocalDate fechaNacimiento, String genero, String correoElectronico, MultipartFile foto, Integer idLocalidad,
			String codigoPostal) throws Exception {

		try {
			PersonaPK personaPK = new PersonaPK(idTipoDocumento, numeroDocumento);

			Persona persona = new Persona();

			persona.setPersonaPK(personaPK);
			persona.setNombre(nombreApellido);
			persona.setFechNacimiento(fechaNacimiento);
			persona.setGenero(Genero.valueOf(genero));
			persona.setEsArgentino(true);
			persona.setCorreoElectronico(correoElectronico);
			persona.setTipoDocumento(tipoDocumentoRepository.findById(idTipoDocumento).get());

			if (foto == null || foto.isEmpty()) {
				persona.setFotoCara(null);
			} else {
				persona.setFotoCara(foto.getBytes());
			}

			Localidad localidad = localidadRepository.findById(idLocalidad).get();
			persona.setLocalidad(localidad);

			if (codigoPostal == null || codigoPostal.isBlank()) {
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

	@Transactional
	public Persona modificar(Integer idTipoDocumento, Integer numeroDocumento, Integer idTipoDocumentoNuevo,
			Integer numeroDocumentoNuevo, String nombreApellido, LocalDate fechaNacimiento, String genero,
			String correoElectronico, MultipartFile foto, Integer idLocalidad, String codigoPostal) throws Exception {

		try {

			Persona persona = personaRepository.findById(new PersonaPK(idTipoDocumento, numeroDocumento)).get();

			PersonaPK personaPK = new PersonaPK(idTipoDocumentoNuevo, numeroDocumentoNuevo);

			persona.setPersonaPK(personaPK);
			persona.setNombre(nombreApellido);
			persona.setFechNacimiento(fechaNacimiento);
			persona.setGenero(Genero.valueOf(genero));
			persona.setEsArgentino(true);
			persona.setCorreoElectronico(correoElectronico);
			persona.setTipoDocumento(tipoDocumentoRepository.findById(idTipoDocumentoNuevo).get());

			if (foto == null || foto.isEmpty()) {
				persona.setFotoCara(null);
			} else {
				persona.setFotoCara(foto.getBytes());
			}

			Localidad localidad = localidadRepository.findById(idLocalidad).get();
			persona.setLocalidad(localidad);

			if (codigoPostal == null || codigoPostal.isBlank()) {
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

	@Transactional
	public void eliminar(Integer idTipoDocumento, Integer numeroDocumento) throws Exception {
		try {
			Persona persona = buscarPorId(idTipoDocumento, numeroDocumento);

			personaRepository.delete(persona);

		} catch (Exception e) {
			throw new Exception("Error al eliminar persona");
		}
	}

	@Transactional(readOnly = true)
	public Persona buscarPorId(Integer idTipoDocumento, Integer numeroDocumento) throws Exception {
		try {
			Persona persona = personaRepository.findById(new PersonaPK(idTipoDocumento, numeroDocumento)).get();

			return persona;
		} catch (Exception e) {
			throw new Exception("Error al buscar persona por id");
		}
	}
	
	@Transactional(readOnly = true)
	public List<Persona> buscarPorNombreOmail(String busqueda) throws Exception {
		try {
			List<Persona> personas = personaRepository.buscarPorNombreOmail(busqueda);

			return personas;
		} catch (Exception e) {
			throw new Exception("Error al buscar personas");
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
