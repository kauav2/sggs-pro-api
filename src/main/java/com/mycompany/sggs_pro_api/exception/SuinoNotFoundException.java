package com.mycompany.sggs_pro_api.exception;

public class SuinoNotFoundException extends RuntimeException {

    public SuinoNotFoundException(String mensagem) {
        super(mensagem);
    }
}