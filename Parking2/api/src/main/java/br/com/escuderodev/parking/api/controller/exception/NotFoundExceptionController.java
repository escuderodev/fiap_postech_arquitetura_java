package br.com.escuderodev.parking.api.controller.exception;

public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}
