package com.eiv.pruebaingreso.enums;

public enum Genero {

	MASCULINO('M'), FEMENINO('F');

	private Character abreviatura;

	private Genero(Character abreviatura) {
		this.abreviatura = abreviatura;
	}

	public char getAbreviatura() {
		return abreviatura;
	}

	public static Genero porAbreviatura(Character abreviatura) {
		switch (abreviatura) {
		case 'M':
			return Genero.MASCULINO;

		case 'F':
			return Genero.FEMENINO;

		default:
			throw new IllegalArgumentException("No existe la abreviatuta " + abreviatura + " para género");
		}
	}

}
