package com.jschool.Day15_GOF.Refactor_2.Exception;

public class MessagingException extends RuntimeException {
    public MessagingException(String message) {
        super(message);
    }

    public MessagingException(String message, Throwable cause) {
        super(message, cause);
    }
}
