package com.R2S.R2Sshop.service.impl;


import com.R2S.R2Sshop.data.dto.CreateUserDTO;
import com.R2S.R2Sshop.data.entity.User;
import com.R2S.R2Sshop.data.mapper.UserMapper;
import com.R2S.R2Sshop.data.repository.UserRepository;
import com.R2S.R2Sshop.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @Override
    public CreateUserDTO create(CreateUserDTO createUserDTO) {
        User user = userMapper.toEntity(createUserDTO);
        user.setId(0);
        return userMapper.toCreateUserDTO(userRepository.save(user));
    }
}
