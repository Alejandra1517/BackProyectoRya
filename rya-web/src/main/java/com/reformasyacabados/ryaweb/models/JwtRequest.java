package com.reformasyacabados.ryaweb.models;

import lombok.Data;

@Data
public class JwtRequest {

    private String username;
    private String password;

}
