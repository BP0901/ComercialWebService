package com.R2S.R2Sshop.config;

import com.R2S.R2Sshop.data.entity.User;
import com.R2S.R2Sshop.data.repository.UserRepository;
import com.R2S.R2Sshop.exception.AccountNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class JwtUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    public JwtUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return new CustomUserDetail(user.get());
        } else {
            throw new AccountNotFoundException("Account not found");
        }
    }
}
