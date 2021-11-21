package com.eiv.pruebaingreso.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class PersonaPK implements Serializable{
	
	@ManyToOne
	protected TipoDocumento tipo_documento;

	protected Integer numero_documento;

	public PersonaPK() {

	}

	public PersonaPK(TipoDocumento tipo_documento, Integer numero_documento) {
		this.tipo_documento = tipo_documento;
		this.numero_documento = numero_documento;
	}

	public TipoDocumento getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(TipoDocumento tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public Integer getNumero_documento() {
		return numero_documento;
	}

	public void setNumero_documento(Integer numero_documento) {
		this.numero_documento = numero_documento;
	}

	@Override
	public int hashCode() {
		return Objects.hash(numero_documento, tipo_documento);
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
		return Objects.equals(numero_documento, other.numero_documento)
				&& Objects.equals(tipo_documento, other.tipo_documento);
	}
	
	
}
