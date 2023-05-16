package com.R2S.R2Sshop.service;


import com.R2S.R2Sshop.data.dto.CreateUserDTO;

public interface UserService {
    public CreateUserDTO create(CreateUserDTO createUserDTO) throws Exception;
}
