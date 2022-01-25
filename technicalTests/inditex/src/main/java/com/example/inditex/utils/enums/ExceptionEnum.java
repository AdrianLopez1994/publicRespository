package com.example.inditex.utils.enums;

public enum ExceptionEnum {

    RESOURCE_NOT_FOUND("Resource not found");

    private String message;

    ExceptionEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
