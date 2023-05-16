package com.R2S.R2Sshop.service.impl;


import com.R2S.R2Sshop.data.dto.CreateUserDTO;
import com.R2S.R2Sshop.data.entity.Role;
import com.R2S.R2Sshop.data.entity.User;
import com.R2S.R2Sshop.data.mapper.RoleMapper;
import com.R2S.R2Sshop.data.mapper.UserMapper;
import com.R2S.R2Sshop.data.repository.RoleRepository;
import com.R2S.R2Sshop.data.repository.UserRepository;
import com.R2S.R2Sshop.service.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Transactional
    @Override
    public CreateUserDTO create(CreateUserDTO createUserDTO) throws Exception {
        createUserDTO.setPassword(bCryptPasswordEncoder.encode(createUserDTO.getPassword()));
        createUserDTO.setId(0);
        Optional<Role> role = roleRepository.findById(createUserDTO.getRoleDTO().getId());
        if(role.isPresent())
            createUserDTO.setRoleDTO(roleMapper.toDTO(role.get()));
        else throw new Exception("Role not found!");
//        User user = userMapper.toEntity(createUserDTO);
//        user = userRepository.save(user);
        return createUserDTO;
//        return userMapper.toCreateUserDTO(userRepository.save(userMapper.toEntity(createUserDTO)));
    }
}
