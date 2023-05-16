package com.R2S.R2Sshop.data.mapper;

import com.R2S.R2Sshop.data.dto.AddressDTO;
import com.R2S.R2Sshop.data.entity.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressMapper {
    Address toEntity(AddressDTO addressDTO);

    AddressDTO toDTO(Address address);
}
