package com.eiv.pruebaingreso.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eiv.pruebaingreso.entities.Localidad;
import com.eiv.pruebaingreso.entities.Persona;
import com.eiv.pruebaingreso.entities.TipoDocumento;
import com.eiv.pruebaingreso.services.LocalidadService;
import com.eiv.pruebaingreso.services.PersonaService;
import com.eiv.pruebaingreso.services.TipoDocumentoService;

@Controller
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;

	@Autowired
	private LocalidadService localidadService;

	@Autowired
	private TipoDocumentoService tipoDocumentoService;

	@GetMapping("/ver")
	public String verPersonas(ModelMap model) {
		try {
			List<Persona> personas = personaService.listarTodas();
			model.addAttribute("personas", personas);

			return "lista-personas.html";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "index.html";
		}

	}

	@GetMapping("/guardar")
	public String guardarPersona(ModelMap model) {
		try {
			List<Localidad> localidades = localidadService.listarTodas();
			model.addAttribute("localidades", localidades);

			List<TipoDocumento> tipoDocumentos = tipoDocumentoService.listarTodos();
			model.addAttribute("tipoDocumentos", tipoDocumentos);

			return "personas-form.html";
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
			return "index.html";
		}

	}

	@PostMapping("/guardar")
	public String guardar(@RequestParam Integer idTipoDocumento, @RequestParam Integer numeroDocumento,
			@RequestParam String nombreApellido, @RequestParam Date fechaNacimiento, @RequestParam String genero,
			@RequestParam String correoElectronico, @RequestParam(required = false) byte[] foto,
			@RequestParam Integer idLocalidad, @RequestParam String codigoPostal, ModelMap model) throws Exception {

		try {

			personaService.crear(idTipoDocumento, numeroDocumento, nombreApellido, fechaNacimiento, genero,
					correoElectronico, foto, idLocalidad, codigoPostal);

			return "lista-personas.html";
		} catch (Exception e) {
			throw new Exception("Error en controlador");
		}

	}
}
