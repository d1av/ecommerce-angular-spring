package com.davi.shop.exceptions;

import java.io.Serial;
import java.util.List;

import com.davi.shop.exceptions.main.NoStackTraceException;

public class DomainException extends NoStackTraceException {
    @Serial
    private static final long serialVersionUID = -414716740491066023L;

    private final List<Error> errors;

    public DomainException(String message, final List<Error> anErrors) {
        super(message);
        this.errors = anErrors;
    }

    public static DomainException with(final Error anErrors) {
        return new DomainException("", List.of(anErrors));
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("", anErrors);
    }

    public List<Error> getErrors() {
        return errors;
    }

    public Error firstError() {
        return errors.get(0);
    }
}