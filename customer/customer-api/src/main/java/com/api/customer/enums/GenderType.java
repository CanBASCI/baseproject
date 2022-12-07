package com.api.customer.enums;

public enum GenderType {

    NONE(0),
    MALE(1),
    FEMALE(2);
    private final int value;
    GenderType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
