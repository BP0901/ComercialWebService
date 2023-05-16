package com.R2S.R2Sshop.controller;

import com.R2S.R2Sshop.data.dto.LoginRequestDTO;
import com.R2S.R2Sshop.service.LoginService;
import com.R2S.R2Sshop.util.constant.ApiURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(ApiURL.LOGIN)
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@Validated @RequestBody LoginRequestDTO loginRequestDTO) throws Exception {
        return ResponseEntity.ok(loginService.login(loginRequestDTO));
    }
}
