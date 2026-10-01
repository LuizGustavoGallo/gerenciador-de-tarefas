package com.gustavo.gerenciadorDeTarefas.Auth;

public class CredenciaisInvalidasException extends RuntimeException {
    public CredenciaisInvalidasException(String message) {
        super(message);
    }
}
