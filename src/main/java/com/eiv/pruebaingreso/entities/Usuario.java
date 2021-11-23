package com.eiv.pruebaingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.PrimaryKeyJoinColumns;
import javax.persistence.Table;

@Entity
@Table(name = "usuarios")
@PrimaryKeyJoinColumns({
    @PrimaryKeyJoinColumn(name="id_tipodocumento"),
    @PrimaryKeyJoinColumn(name="numero_documento")
})
public class Usuario extends Persona{
	
	@Column(name = "nombre_usuario", length = 50, nullable = false, unique = true)
	protected String usuario;
	@Column(name = "hashed_pwd", length = 200, nullable = false)
	protected String password;

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

}
