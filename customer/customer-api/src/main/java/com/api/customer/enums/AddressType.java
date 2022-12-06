package com.api.customer.enums;

public enum AddressType {

    NONE(0),
    HOME(1),
    BUSINESS(2);
    private final int value;
    AddressType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
