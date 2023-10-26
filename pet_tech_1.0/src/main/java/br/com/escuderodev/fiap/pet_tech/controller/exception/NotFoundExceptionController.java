package br.com.escuderodev.fiap.pet_tech.controller.exception;

public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}
