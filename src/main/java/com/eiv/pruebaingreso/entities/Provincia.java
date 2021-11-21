package com.eiv.pruebaingreso.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.eiv.pruebaingreso.enums.Region;

@Entity
@Table(name = "provincias")
public class Provincia {

	@Id
	@Column(name = "id_provincia")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", length = 400, nullable = false)
	private String nombre;

	@Column(name = "region", nullable = false, length = 3)
	@Enumerated(EnumType.STRING)
	private Region region;

	public Provincia() {

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

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

}
