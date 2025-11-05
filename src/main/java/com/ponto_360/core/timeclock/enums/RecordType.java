package com.ponto_360.core.timeclock.enums;

import lombok.Getter;

@Getter
public enum RecordType {
    CLOCK_IN("01", "Entrada"),
    LUNCH_OUT("02", "Saída Almoço"),
    LUNCH_IN("03", "Retorno Almoço"),
    CLOCK_OUT("04", "Saída Final");

    private final String code;
    private final String description;

    RecordType(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
