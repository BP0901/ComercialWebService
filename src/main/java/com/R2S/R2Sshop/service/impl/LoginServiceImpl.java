package com.R2S.R2Sshop.service.impl;

import com.R2S.R2Sshop.config.CustomUserDetail;
import com.R2S.R2Sshop.data.dto.LoginRequestDTO;
import com.R2S.R2Sshop.data.entity.User;
import com.R2S.R2Sshop.data.repository.UserRepository;
import com.R2S.R2Sshop.service.LoginService;
import com.R2S.R2Sshop.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtUtils;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String login(LoginRequestDTO loginRequestDTO) throws Exception {
        User user = userRepository.findByUsername(loginRequestDTO.getUsername()).orElseThrow(() -> new Exception("Username or password is incorrect!"));
        if(!bCryptPasswordEncoder.matches(loginRequestDTO.getPassword(),user.getPassword()))
            throw new Exception("Username or password is incorrect!");
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequestDTO.getUsername(),
                        loginRequestDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        CustomUserDetail userDetails = (CustomUserDetail) authentication.getPrincipal();
        return this.jwtUtils.generateToken(userDetails);
    }
}
