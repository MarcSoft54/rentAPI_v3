package com.marcdev.rent_v3.handlerException;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomMessage{
    String status;
    String message;
    String debugMessage;
}
