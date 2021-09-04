package com.jm.wikigames.generalitem.converter;

import com.jm.wikigames.generalitem.model.enums.Genre;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class GenreEnumToStringConverter implements AttributeConverter <Genre, String> {
    @Override
    public String convertToDatabaseColumn(Genre genre) {
        return genre.name();
    }

    @Override
    public Genre convertToEntityAttribute(String s) {
        String genre = s.trim().replace(" ", "_");
        return Genre.valueOf(genre.toUpperCase());
    }
}
