package com.marcdev.rent_v3.handlerException;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomMessage> handleOtherExceptions(Exception e, WebRequest request){
        String requestUrl = ((ServletWebRequest) request).getRequest().getRequestURI().toString();
        CustomMessage message = new CustomMessage(
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                "you're not authorized",
                "this link went wrong "+requestUrl
        );
        return new ResponseEntity<>(message, new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExpiredJwtException.class)
    public ResponseEntity<CustomMessage> expiredJwtToken(ExpiredJwtException jwtException){
        CustomMessage message = new CustomMessage(
                "UNAUTHORIZED",
                "you're not authenticated",
                "token expired "+ jwtException.getMessage()
        );
        return new ResponseEntity<>(message, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }
}
