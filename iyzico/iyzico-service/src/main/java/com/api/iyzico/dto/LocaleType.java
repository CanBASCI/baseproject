package com.api.iyzico.dto;


public enum LocaleType {
    EN("en"),
    TR("tr");

    private final String value;

    LocaleType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
