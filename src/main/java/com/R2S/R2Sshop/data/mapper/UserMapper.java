package com.R2S.R2Sshop.data.mapper;

import com.R2S.R2Sshop.data.dto.CreateUserDTO;
import com.R2S.R2Sshop.data.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {RoleMapper.class, AddressMapper.class})
public interface UserMapper {
    @Mapping(source = "addressDTOS", target = "addresses")
    @Mapping(source = "roleDTO", target = "role")
    User toEntity(CreateUserDTO createUserDTO);
    @Mapping(source = "addresses", target = "addressDTOS")
    @Mapping(source = "role", target = "roleDTO")
    CreateUserDTO toCreateUserDTO(User user);
}
