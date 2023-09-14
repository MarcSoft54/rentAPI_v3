package com.marcdev.rent_v3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessage extends RuntimeException{
    String status;
    String message;
    String debugMessage;
}
