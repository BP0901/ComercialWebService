package com.R2S.R2Sshop.controller;

import com.R2S.R2Sshop.data.dto.CreateUserDTO;
import com.R2S.R2Sshop.service.UserService;
import com.R2S.R2Sshop.util.constant.ApiURL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(ApiURL.USERS)
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateUserDTO createUserDTO) throws Exception {
        return ResponseEntity.ok(userService.create(createUserDTO));
    }
}
