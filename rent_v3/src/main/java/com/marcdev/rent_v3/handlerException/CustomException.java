package com.marcdev.rent_v3.handlerException;

import io.jsonwebtoken.ExpiredJwtException;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;


@RestControllerAdvice
public class CustomException{

//    IllegalStateException.class, ServletException.class, ExpiredJwtException.class, AccessDeniedException.class


    @ExceptionHandler(IllegalStateException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public CustomMessage customMessageResponseEntity(Exception e){
        return CustomMessage.builder()
                  .message("you're not authenticated")
                  .status("UNAUTHENTICATED" +e.getMessage())
                  .debugMessage("bad request")
                  .build();
    }

    @ExceptionHandler(value = ExpiredJwtException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public CustomMessage invalidToken(ExpiredJwtException e){
        return CustomMessage.builder()
                .message("you're not authenticated")
                .status("UNAUTHENTICATED" + e.getMessage())
                .debugMessage("token expired")
                .build();
    }

}
