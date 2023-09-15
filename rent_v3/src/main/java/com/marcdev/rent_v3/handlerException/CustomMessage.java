package com.marcdev.rent_v3.handlerException;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomMessage extends RuntimeException{
    String status;
    String message;
    String debugMessage;
}
