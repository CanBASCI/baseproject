package com.api.iyzico.dto;

public enum HttpMethodType {
    GET,
    POST,
    DELETE,
    PUT;

    public static boolean isValidRequestFor(HttpMethodType httpMethod) {
        return POST.equals(httpMethod) || PUT.equals(httpMethod) || DELETE.equals(httpMethod);
    }
}
