package br.com.escuderodev.fiap.pet_tech.controllers;

public class NotFoundExceptionController extends RuntimeException{

    public NotFoundExceptionController(String message) {
        super(message);
    }
}
