package com.eiv.pruebaingreso.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class GeneroConverter implements AttributeConverter<Genero, Character> {

	@Override
	public Character convertToDatabaseColumn(Genero genero) {
		return genero.getAbreviatura();
	}

	@Override
	public Genero convertToEntityAttribute(Character dbData) {
		return Genero.porAbreviatura(dbData);
	}

}
