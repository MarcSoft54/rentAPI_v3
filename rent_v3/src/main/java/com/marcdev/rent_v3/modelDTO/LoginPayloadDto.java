package com.marcdev.rent_v3.modelDTO;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginPayloadDto {
    String email;
    String password;
}
