package com.piratesofJava.spring_security.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthenticationResponse {

  private String token;
}
