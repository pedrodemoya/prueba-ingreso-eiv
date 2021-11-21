package com.eiv.pruebaingreso.entities;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.eiv.pruebaingreso.enums.Genero;

@Entity
@Table(name = "personas")
@Inheritance(strategy=InheritanceType.JOINED)
public class Persona {

	@EmbeddedId
	private PersonaPK personaPK;

	@Column(name = "nombre_apellido", length = 400, nullable = false)
	private String nombrApellido;

	@Column(name = "fecha_nacimiento", nullable = false)
	private Date fechNacimiento;

	@Column(name = "genero", nullable = false, length = 1)
	@Enumerated(EnumType.STRING)
	private Genero genero;

	@Column(name = "es_argentino", nullable = false)
	private Boolean esArgentino;

	@Column(name = "correo_electronico", length = 300, nullable = true)
	private String correoElectronico;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "foto_cara", nullable = true)
	private byte[] fotoCara;

	@ManyToOne
	private Localidad localidad;

	@Column(name = "codigo_postal", length = 10, nullable = false)
	private String codigoPostal;

	public Persona() {

	}

	public PersonaPK getPersonaPK() {
		return personaPK;
	}

	public void setPersonaPK(PersonaPK personaPK) {
		this.personaPK = personaPK;
	}

	public String getNombrApellido() {
		return nombrApellido;
	}

	public void setNombrApellido(String nombrApellido) {
		this.nombrApellido = nombrApellido;
	}

	public Date getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(Date fechNacimiento) {
		this.fechNacimiento = fechNacimiento;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Boolean getEsArgentino() {
		return esArgentino;
	}

	public void setEsArgentino(Boolean esArgentino) {
		this.esArgentino = esArgentino;
	}

	public String getCorreoElectronico() {
		return correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public byte[] getFotoCara() {
		return fotoCara;
	}

	public void setFotoCara(byte[] fotoCara) {
		this.fotoCara = fotoCara;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

}
