package com.api.rest.parking.web.dto.mapper;

import com.api.rest.parking.entity.User;
import com.api.rest.parking.web.dto.RequestUserDTO;
import org.modelmapper.ModelMapper;

import java.util.List;

public class UserMapper {

    public static User toUser(RequestUserDTO userCreateDTO){
        return new ModelMapper().map(userCreateDTO, User.class);
    }

    public static ResponseUserDTO toUserDto(User user){
        return new ModelMapper().map(user, ResponseUserDTO.class);
    }
}
