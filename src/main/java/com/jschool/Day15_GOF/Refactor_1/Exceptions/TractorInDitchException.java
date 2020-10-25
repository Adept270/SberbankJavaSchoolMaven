package com.jschool.Day15_GOF.Refactor_1.Exceptions;

public class TractorInDitchException extends RuntimeException {
    public TractorInDitchException(String message) {
        super(message);
    }

    public TractorInDitchException(String message, Throwable cause) {
        super(message, cause);
    }
}
