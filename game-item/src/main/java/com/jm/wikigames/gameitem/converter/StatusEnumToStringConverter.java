package com.jm.wikigames.gameitem.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.jm.wikigames.gameitem.model.enums.Status;

@Converter
public class StatusEnumToStringConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(status.toString().charAt(0))
                .append(status.toString().toLowerCase().substring(1));

        return stringBuilder.toString();
    }

    @Override
    public Status convertToEntityAttribute(String s) {
        return Status.valueOf(s.toUpperCase());
    }
}
