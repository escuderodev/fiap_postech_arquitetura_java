package br.com.escuderodev.fiap.gradle.api.usuarios_pettech.controller.exception;

public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}
