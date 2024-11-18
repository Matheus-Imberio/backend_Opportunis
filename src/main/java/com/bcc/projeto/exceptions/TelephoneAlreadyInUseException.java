package com.bcc.projeto.exceptions;

public class TelephoneAlreadyInUseException extends RuntimeException {
    public TelephoneAlreadyInUseException(String message) {
        super(message);
    }
}
