package com.eiv.pruebaingreso;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eiv.pruebaingreso.entities.PersonaPK;
import com.eiv.pruebaingreso.entities.Usuario;
import com.eiv.pruebaingreso.enums.Genero;
import com.eiv.pruebaingreso.repositories.LocalidadRepository;
import com.eiv.pruebaingreso.repositories.PersonaRepository;
import com.eiv.pruebaingreso.repositories.ProvinciaRepository;
import com.eiv.pruebaingreso.repositories.TipoDocumentoRepository;
import com.eiv.pruebaingreso.repositories.UsuarioRepository;

@SpringBootTest
class PruebaingresoApplicationTests {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	void contextLoads() {
	}

	@Test
	public void crear() throws Exception {

//		TipoDocumento tipoDocumento = new TipoDocumento();
//		tipoDocumento.setNombre("Documento Nacional de Identidad");
//		tipoDocumento.setAbreviatura("DNI");
//		tipoDocumento.setValidarComoCuit(true);
//		tipoDocumento = tipoDocumentoRepository.save(tipoDocumento);
//
//		Provincia provincia = new Provincia();
//		provincia.setNombre("Santa Fe");
//		provincia.setRegion(Region.valueOf("PAM"));
//		Provincia provinciaCreada = provinciaRepository.save(provincia);
//
//		Localidad localidad = new Localidad();
//		localidad.setCodigoPostal("2000");
//		localidad.setNombre("Rosario");
//		localidad.setProvincia(provinciaCreada);
//		Localidad localidadCreada = localidadRepository.save(localidad);

		PersonaPK personaPK = new PersonaPK(2, 13332283);

		Usuario persona = new Usuario();

		persona.setPersonaPK(personaPK);
		persona.setNombre("Ursula Perez");
		persona.setFechNacimiento(LocalDate.of(1991, 12, 30));
		persona.setGenero(Genero.FEMENINO);
		persona.setEsArgentino(true);
		persona.setCorreoElectronico("ursulaperez@gmail.com");
		persona.setLocalidad(localidadRepository.findById(2).get());
		persona.setCodigoPostal("2200");		
		persona.setUsuario("admin");
		persona.setPassword(encoder.encode("admin"));
		persona = usuarioRepository.save(persona);
		//usuarioRepository.save(usuario);
		// assertTrue(usuarioCreado.getPassword().equalsIgnoreCase(usuario.getPassword()));
	}

}
