package com.mycompany.sggs_pro_api.exception;

public class InvalidCredentialsException extends RuntimeException {

    public InvalidCredentialsException(String mensagem) {
        super(mensagem);
    }
}