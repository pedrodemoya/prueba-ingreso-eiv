package com.eiv.pruebaingreso.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import com.eiv.pruebaingreso.enums.Genero;

@Entity
@Table(name = "personas")
@Inheritance(strategy = InheritanceType.JOINED)
public class Persona {

	@EmbeddedId
	@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "id_tipodocumento"),
			@PrimaryKeyJoinColumn(name = "numero_documento") })
	protected PersonaPK personaPK;

	@ManyToOne
	@JoinColumn(name = "id_tipodocumento", insertable = false, updatable = false)
	protected TipoDocumento tipoDocumento;

	@Column(name = "nombre_apellido", length = 400, nullable = false)
	protected String nombre;

	@Column(name = "fecha_nacimiento", nullable = false)
	protected LocalDate fechNacimiento;

	@Column(name = "genero", nullable = false, length = 1)
	protected Genero genero;

	@Column(name = "es_argentino", nullable = false)
	protected Boolean esArgentino;

	@Column(name = "correo_electronico", length = 300, nullable = true)
	protected String correoElectronico;

	@Lob
	@Basic(fetch = FetchType.LAZY)
	@Column(name = "foto_cara", nullable = true, columnDefinition = "BLOB")
	protected byte[] fotoCara;

	@ManyToOne(optional = false)
	@JoinColumn(name = "id_localidad")
	protected Localidad localidad;

	@Column(name = "codigo_postal", length = 10, nullable = false)
	protected String codigoPostal;

	public Persona() {

	}

	public PersonaPK getPersonaPK() {
		return personaPK;
	}

	public void setPersonaPK(PersonaPK personaPK) {
		this.personaPK = personaPK;
	}

	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechNacimiento() {
		return fechNacimiento;
	}

	public void setFechNacimiento(LocalDate fechNacimiento) {
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

	@Override
	public int hashCode() {
		return Objects.hash(personaPK);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(personaPK, other.personaPK);
	}

}
