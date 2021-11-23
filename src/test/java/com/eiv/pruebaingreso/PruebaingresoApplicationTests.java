package com.eiv.pruebaingreso;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.eiv.pruebaingreso.entities.Localidad;
import com.eiv.pruebaingreso.entities.PersonaPK;
import com.eiv.pruebaingreso.entities.Provincia;
import com.eiv.pruebaingreso.entities.TipoDocumento;
import com.eiv.pruebaingreso.entities.Usuario;
import com.eiv.pruebaingreso.enums.Genero;
import com.eiv.pruebaingreso.enums.Region;
import com.eiv.pruebaingreso.repositories.LocalidadRepository;
import com.eiv.pruebaingreso.repositories.PersonaRepository;
import com.eiv.pruebaingreso.repositories.ProvinciaRepository;
import com.eiv.pruebaingreso.repositories.TipoDocumentoRepository;

@SpringBootTest
class PruebaingresoApplicationTests {

	@Autowired
	private PersonaRepository personaRepository;

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

		TipoDocumento tipoDocumento = new TipoDocumento();
		tipoDocumento.setNombre("Documento Nacional de Identidad");
		tipoDocumento.setAbreviatura("DNI");
		tipoDocumento.setValidarComoCuit(true);
		tipoDocumento = tipoDocumentoRepository.save(tipoDocumento);

		Provincia provincia = new Provincia();
		provincia.setNombre("Santa Fe");
		provincia.setRegion(Region.valueOf("PAM"));
		Provincia provinciaCreada = provinciaRepository.save(provincia);

		Localidad localidad = new Localidad();
		localidad.setCodigoPostal("2000");
		localidad.setNombre("Rosario");
		localidad.setProvincia(provinciaCreada);
		Localidad localidadCreada = localidadRepository.save(localidad);

		PersonaPK personaPK = new PersonaPK(tipoDocumento, 12123123);

		Usuario persona = new Usuario();

		persona.setPersonaPK(personaPK);
		persona.setNombrApellido("Jorge Perez");
		persona.setFechNacimiento(new Date());
		persona.setGenero(Genero.valueOf("M"));
		persona.setEsArgentino(true);
		persona.setCorreoElectronico("jorgeperez@gmail.com");
		persona.setLocalidad(localidadCreada);
		persona.setCodigoPostal("2000");		
		persona.setUsuario("admin");
		persona.setPassword(encoder.encode("admin"));
		persona = personaRepository.save(persona);
		//usuarioRepository.save(usuario);
		// assertTrue(usuarioCreado.getPassword().equalsIgnoreCase(usuario.getPassword()));
	}

}
