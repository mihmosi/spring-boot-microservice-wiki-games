package com.jm.wikigames.generalitem.converter;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Status {
    REALISE("В релизе"),
    PRODUCTION("В разработке");

    private final String value;

    public String getValue() {
        return this.value;
    }
}
