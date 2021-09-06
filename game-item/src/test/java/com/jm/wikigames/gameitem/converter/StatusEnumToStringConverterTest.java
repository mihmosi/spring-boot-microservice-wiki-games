package com.jm.wikigames.gameitem.converter;

import com.jm.wikigames.gameitem.model.enums.Status;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StatusEnumToStringConverterTest {

    @Test
    public void enumToString_test() {
        StatusEnumToStringConverter statusEnumToStringConverter = new StatusEnumToStringConverter();

        Assertions.assertEquals(statusEnumToStringConverter.convertToDatabaseColumn(Status.RELEASE), "Release");
        Assertions.assertEquals(statusEnumToStringConverter.convertToDatabaseColumn(Status.PRODUCTION), "Production");
    }

    @Test
    public void  stringToEnum_test() {
        StatusEnumToStringConverter statusEnumToStringConverter = new StatusEnumToStringConverter();

        Assertions.assertEquals(statusEnumToStringConverter.convertToEntityAttribute("Release"), Status.RELEASE);
        Assertions.assertEquals(statusEnumToStringConverter.convertToEntityAttribute("Production"), Status.PRODUCTION);
    }

}
