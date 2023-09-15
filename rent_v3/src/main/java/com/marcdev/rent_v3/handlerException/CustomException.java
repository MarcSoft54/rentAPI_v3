package com.marcdev.rent_v3.handlerException;

import io.jsonwebtoken.ExpiredJwtException;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomException extends ResponseEntityExceptionHandler {

//    IllegalStateException.class, ServletException.class, ExpiredJwtException.class, AccessDeniedException.class


    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public CustomMessage customMessageResponseEntity(Exception e){
        return CustomMessage.builder()
                  .message("you're not authenticated")
                  .status("UNAUTHENTICATED " +e.getMessage())
                  .debugMessage("check you controller and look if there's not and AccessDenied some where ...")
                  .build();
    }

    @ExceptionHandler(ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CustomMessage invalidToken(ExpiredJwtException jwtException){
        return CustomMessage.builder()
                .message("you're not authenticated")
                .status("UNAUTHENTICATED" +jwtException.getMessage())
                .debugMessage("token expired")
                .build();
    }

}

