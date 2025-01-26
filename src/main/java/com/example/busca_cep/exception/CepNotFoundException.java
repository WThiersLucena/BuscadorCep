package com.example.busca_cep.exception;

public class CepNotFoundException extends RuntimeException {
    
    public CepNotFoundException(String message) {
        super(message);
    }
    
}
