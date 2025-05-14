package com.piratesofJava.spring_security.mapper;

import com.piratesofJava.spring_security.dto.UserRequest;
import com.piratesofJava.spring_security.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

  User toUser(UserRequest userRequest);

  UserRequest toUserRequest(User user);
}
