package com.rumal001.webapp.DTO;

import lombok.Getter;

@Getter
public class AuthenticationResponse {
    private String jwt;
    public AuthenticationResponse(String jwt) {
        this.jwt = jwt;
    }
}
