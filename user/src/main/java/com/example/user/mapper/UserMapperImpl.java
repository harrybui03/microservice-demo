package com.example.user.mapper;

import com.example.user.dto.UserDTO;
import com.example.user.model.User;

public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO toUserDTO(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setId( entity.getId() );
        userDTO.setEmail( entity.getEmail() );
        userDTO.setUsername( entity.getUsername() );

        return userDTO;
    }

    @Override
    public User toUser(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setId( dto.getId() );
        user.setEmail( dto.getEmail() );
        user.setUsername( dto.getUsername() );

        return user;
    }
}

