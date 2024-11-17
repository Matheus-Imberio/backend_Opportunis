package com.bcc.projeto.exceptions;

public class CNPJAlreadyInUseException extends RuntimeException{
    public CNPJAlreadyInUseException(String message) {
        super(message);
    }
}
