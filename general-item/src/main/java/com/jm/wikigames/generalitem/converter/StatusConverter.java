package com.jm.wikigames.generalitem.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Objects;

@Converter
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        if (Objects.isNull(status)) {
            return null;
        }

        switch (status) {
            case REALISE:
                return "В релизе";
            case PRODUCTION:
                return "В разработке";
            default:
                throw new IllegalArgumentException(status + " not supported.");
        }
    }

    @Override
    public Status convertToEntityAttribute(String value) {
        if (Objects.isNull(value)) {
            return null;
        }

        switch (value) {
            case "В релизе":
                return Status.REALISE;
            case "В разработке":
                return Status.PRODUCTION;
            default:
                throw new IllegalArgumentException(value + " not supported.");
        }
    }
}
