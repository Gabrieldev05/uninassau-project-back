package com.uninassau.backpro.exceptions;

public class MensagemErrorException extends RuntimeException {

    public MensagemErrorException(String message) {
        super(message);
    }

    public MensagemErrorException(String message, Throwable cause) {
        super(message, cause);
    }
}
