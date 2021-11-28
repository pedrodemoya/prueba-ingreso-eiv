package com.eiv.pruebaingreso.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipos_documentos")
public class TipoDocumento {

	@Id
	@Column(name = "id_tipodocumento")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", length = 200, nullable = false, unique = true)
	private String nombre;

	@Column(name = "abreviatura", length = 200, nullable = false, unique = true)
	private String abreviatura;

	@Column(name = "validar_como_cuit", nullable = false)
	private Boolean validarComoCuit;

	public TipoDocumento() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getAbreviatura() {
		return abreviatura;
	}

	public void setAbreviatura(String abreviatura) {
		this.abreviatura = abreviatura;
	}

	public Boolean getValidarComoCuit() {
		return validarComoCuit;
	}

	public void setValidarComoCuit(Boolean validarComoCuit) {
		this.validarComoCuit = validarComoCuit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TipoDocumento other = (TipoDocumento) obj;
		return Objects.equals(id, other.id);
	}

}
