package com.davi.shop.validation;

import java.util.Objects;

public abstract class Validator {
    private final ValidationHandler handler;

    public Validator(final ValidationHandler aHandler) {
        this.handler = Objects.requireNonNull(aHandler);
    }

    public abstract void validate();

    protected ValidationHandler validationHandler() {
        return this.handler;
    }
}