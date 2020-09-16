package com.jschool.Day4_Exceptions.MyExceptions.AccountException;

public class InvalidPinException extends AccountExceptions {
    public InvalidPinException(String message) {
        super(message);
    }
}
