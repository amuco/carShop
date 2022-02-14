package com.carseller.cars.exception;

public class NotFoundException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public NotFoundException(NotFound notFound){super(notFound.getMessage());}
}
