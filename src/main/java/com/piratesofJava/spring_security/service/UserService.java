package com.piratesofJava.spring_security.service;

import com.piratesofJava.spring_security.dto.AuthenticationRequest;
import com.piratesofJava.spring_security.dto.AuthenticationResponse;
import com.piratesofJava.spring_security.dto.UserRequest;

public interface UserService {

  AuthenticationResponse createUser(UserRequest userRequest);

  AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);
}
