package com.example.productservice.services;

import com.example.productservice.dtos.UserResponseDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class TokenService {
    private RestTemplate restTemplate;
    public TokenService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public boolean validateToken(String token){
        UserResponseDto userResponseDto = restTemplate.postForObject("http://localhost:9000/users/validate/" + token, null, UserResponseDto.class );
        return userResponseDto != null;
    }
}
