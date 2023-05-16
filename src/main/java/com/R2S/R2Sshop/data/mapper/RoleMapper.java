package com.R2S.R2Sshop.data.mapper;

import com.R2S.R2Sshop.data.dto.RoleDTO;
import com.R2S.R2Sshop.data.entity.Role;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role toEntity(RoleDTO roleDTO);

    RoleDTO toDTO(Role role);
}
