package com.eiv.pruebaingreso.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.eiv.pruebaingreso.entities.TipoDocumento;
import com.eiv.pruebaingreso.repositories.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {
	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	@Transactional
	public TipoDocumento crear(String nombre, String abreviatura) throws Exception {
		try {
			TipoDocumento tipoDocumento = new TipoDocumento();

			tipoDocumento.setNombre(nombre);
			tipoDocumento.setAbreviatura(abreviatura);
			tipoDocumento.setValidarComoCuit(true);

			tipoDocumentoRepository.save(tipoDocumento);

			return tipoDocumento;
		} catch (Exception e) {
			throw new Exception("Error al crear tipo de documento");
		}
	}

	@Transactional
	public TipoDocumento modificar(Integer id, String nombre, String abreviatura, Boolean validarComoCuit)
			throws Exception {
		try {
			TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id).get();

			tipoDocumento.setNombre(nombre);
			tipoDocumento.setAbreviatura(abreviatura);
			tipoDocumento.setValidarComoCuit(validarComoCuit);

			tipoDocumentoRepository.save(tipoDocumento);

			return tipoDocumento;
		} catch (Exception e) {
			throw new Exception("Error al modificar tipo de documento");
		}
	}

	@Transactional
	public void eliminar(Integer id) throws Exception {
		try {
			TipoDocumento tipoDocumento = tipoDocumentoRepository.findById(id).get();

			tipoDocumentoRepository.delete(tipoDocumento);

		} catch (Exception e) {
			throw new Exception("Error al eliminar tipo de documento");
		}
	}

	@Transactional(readOnly = true)
	public List<TipoDocumento> listarTodos() throws Exception {
		try {
			List<TipoDocumento> tiposDocumentos = tipoDocumentoRepository.findAll();

			return tiposDocumentos;
		} catch (Exception e) {
			throw new Exception("Error al listar tipos de documentos");
		}
	}
}
