package com.davi.shop.exceptions;

import org.springframework.http.HttpStatus;

public class ShopAPIException extends RuntimeException {
    private HttpStatus status;
    private String message;

    public ShopAPIException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public ShopAPIException(String message, HttpStatus status, String message1) {
        super(message);
        this.status = status;
        this.message = message1;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
