package com.marcdev.rent_v3.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
@Component
@NoArgsConstructor
public class LoginPayloadDto {
    String email;
    String password;
}
