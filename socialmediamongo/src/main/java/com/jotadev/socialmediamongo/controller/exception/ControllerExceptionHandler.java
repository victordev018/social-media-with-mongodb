package com.jotadev.socialmediamongo.controller.exception;

import com.jotadev.socialmediamongo.service.exception.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice   // classe para tratar possiveis erros
public class ControllerExceptionHandler {

    // quando ocorrer esta exceção, faça este tratamento
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException exception, HttpServletRequest request){

        HttpStatus status = HttpStatus.NOT_FOUND;   // code 404
        StandardError error = new StandardError(System.currentTimeMillis(),
                status.value(),
                "Not found", exception.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(status).body(error);
    }
}
