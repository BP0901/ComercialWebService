package com.R2S.R2Sshop.data.mapper;

import com.R2S.R2Sshop.data.dto.CreateUserDTO;
import com.R2S.R2Sshop.data.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(CreateUserDTO createUserDTO);

    CreateUserDTO toCreateUserDTO(User user);
}
