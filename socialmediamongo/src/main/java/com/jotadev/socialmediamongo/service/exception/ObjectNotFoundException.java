package com.jotadev.socialmediamongo.service.exception;

public class ObjectNotFoundException extends RuntimeException{

    private static final long serialVersionUUID = 1L;

    public ObjectNotFoundException(String message){
        super(message);
    }
}
