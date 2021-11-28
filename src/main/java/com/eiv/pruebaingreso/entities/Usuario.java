package com.eiv.pruebaingreso.entities;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

import com.eiv.pruebaingreso.enums.Genero;

@Entity
@Table(name = "usuarios")
@PrimaryKeyJoinColumns({ @PrimaryKeyJoinColumn(name = "id_tipodocumento"),
		@PrimaryKeyJoinColumn(name = "numero_documento") })
public class Usuario extends Persona {

	@Column(name = "nombre_usuario", length = 50, nullable = false, unique = true)
	private String usuario;
	@Column(name = "hashed_pwd", length = 200, nullable = false)
	private String password;

	public Usuario() {
		super();
	}

	public Usuario(String usuario, String password) {
		super();
		this.usuario = usuario;
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(usuario);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(usuario, other.usuario);
	}

}
