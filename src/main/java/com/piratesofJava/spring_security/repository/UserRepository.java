package com.piratesofJava.spring_security.repository;

import com.piratesofJava.spring_security.entity.User;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, UUID> {

  User findByEmail(String email);
}
