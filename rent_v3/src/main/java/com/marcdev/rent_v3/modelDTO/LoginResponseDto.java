package com.marcdev.rent_v3.modelDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    String username;
    String accessToken;
}
