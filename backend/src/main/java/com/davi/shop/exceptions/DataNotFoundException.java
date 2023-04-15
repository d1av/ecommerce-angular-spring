package com.davi.shop.exceptions;

public class DataNotFoundException extends RuntimeException {
    /**
     * 
     */
    private static final long serialVersionUID = -2231720171557938508L;

    public DataNotFoundException(String msg) {
        super(msg);
    }
}
