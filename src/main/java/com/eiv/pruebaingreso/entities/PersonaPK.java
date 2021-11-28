package com.eiv.pruebaingreso.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class PersonaPK implements Serializable {

	@Column(name = "id_tipodocumento")
	private Integer id_tipodocumento;

	@Column(name = "numero_documento")
	private Integer numero_documento;

	public PersonaPK() {

	}

	public PersonaPK(int id_tipodocumento, Integer numero_documento) {
		super();
		this.id_tipodocumento = id_tipodocumento;
		this.numero_documento = numero_documento;
	}

	public int getId_tipodocumento() {
		return id_tipodocumento;
	}

	public void setId_tipodocumento(Integer id_tipodocumento) {
		this.id_tipodocumento = id_tipodocumento;
	}

	public Integer getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id_tipodocumento, numero_documento);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaPK other = (PersonaPK) obj;
		return id_tipodocumento == other.id_tipodocumento && Objects.equals(numero_documento, other.numero_documento);
	}

	
}
