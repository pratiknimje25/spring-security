package com.piratesofJava.spring_security.controller;

import com.piratesofJava.spring_security.dto.AuthenticationRequest;
import com.piratesofJava.spring_security.dto.AuthenticationResponse;
import com.piratesofJava.spring_security.dto.UserRequest;
import com.piratesofJava.spring_security.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @PostMapping("/register")
  public ResponseEntity<AuthenticationResponse> register(
      @RequestBody @Valid UserRequest userRequest) {
    return ResponseEntity.ok(userService.createUser(userRequest));
  }

  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody @Valid AuthenticationRequest authenticationRequest) {
    return ResponseEntity.ok(userService.authenticate(authenticationRequest));
  }
}
