package com.piratesofJava.spring_security.service.impl;

import com.piratesofJava.spring_security.dto.AuthenticationRequest;
import com.piratesofJava.spring_security.dto.AuthenticationResponse;
import com.piratesofJava.spring_security.dto.UserRequest;
import com.piratesofJava.spring_security.entity.User;
import com.piratesofJava.spring_security.enums.Role;
import com.piratesofJava.spring_security.repository.UserRepository;
import com.piratesofJava.spring_security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final JwtService jwtService;

  @Override
  public AuthenticationResponse createUser(UserRequest userRequest) {
    User newUser =
        User.builder()
            .firstName(userRequest.getFirstName())
            .lastName(userRequest.getLastName())
            .email(userRequest.getEmail())
            .password(passwordEncoder.encode(userRequest.getPassword()))
            .role(Role.USER)
            .build();
    userRepository.save(newUser);
    String jwtToken = jwtService.generateToken(newUser);

    return AuthenticationResponse.builder().token(jwtToken).build();
  }

  @Override
  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()));

    User user = userRepository.findByEmail(request.getEmail());
    String jwtToken = jwtService.generateToken(user);
    return AuthenticationResponse.builder().token(jwtToken).build();
  }
}
