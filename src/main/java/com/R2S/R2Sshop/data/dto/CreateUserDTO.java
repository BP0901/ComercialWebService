package com.R2S.R2Sshop.data.dto;
import lombok.Data;

import java.util.List;

@Data
public class CreateUserDTO {
    private long id;
    private String username;
    private String password;
    private RoleDTO roleDTO;
    private List<AddressDTO> addressDTOS;
}