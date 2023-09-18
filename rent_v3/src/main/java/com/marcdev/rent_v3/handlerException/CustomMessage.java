package com.marcdev.rent_v3.handlerException;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomMessage{
    String status;
    String message;
    String debugMessage;
}
