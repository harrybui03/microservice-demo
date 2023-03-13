package com.example.user.mapper;

import com.example.user.dto.UserDTO;
import com.example.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(target = "id", source = "entity.id")
    @Mapping(target = "email", source = "entity.email")
    @Mapping(target = "username", source = "entity.username")
    UserDTO toUserDTO(User entity);

    @Mapping(target = "id", source = "dto.id")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "username", source = "dto.username")
    User toUser(UserDTO dto);
}
