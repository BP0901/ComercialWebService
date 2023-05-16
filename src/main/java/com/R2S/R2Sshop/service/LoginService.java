package com.R2S.R2Sshop.service;

import com.R2S.R2Sshop.data.dto.LoginRequestDTO;

public interface LoginService {
    String login(LoginRequestDTO loginRequestDTO) throws Exception;
}
