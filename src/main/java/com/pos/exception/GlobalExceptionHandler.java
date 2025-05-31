package com.pos.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public String handleError(Exception e) {
        // Aquí puedes devolver una vista personalizada
        return "customErrorPage"; // El nombre de la vista personalizada
    }
}
