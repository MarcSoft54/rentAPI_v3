package com.marcdev.rent_v3.exceptionManager;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(ExpiredJwtException.class)
    public String tokenExpired(ExpiredJwtException exception){
        return exception.getMessage();
    }
}
