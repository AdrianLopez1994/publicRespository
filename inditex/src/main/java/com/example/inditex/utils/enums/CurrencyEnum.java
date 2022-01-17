package com.example.inditex.utils.enums;

public enum CurrencyEnum {

    EUR("EUR");

    private String value;

    CurrencyEnum(final String enumValue) {
        this.value = enumValue;
    }

    public String getValue() {
        return value;
    }
}
