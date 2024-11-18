package com.bcc.projeto.exceptions;

public class CPFAlreadyInUseException extends RuntimeException {
    public CPFAlreadyInUseException(String message) {
        super(message);
    }
}
