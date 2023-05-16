package com.R2S.R2Sshop.config;

import com.R2S.R2Sshop.data.entity.Role;
import com.R2S.R2Sshop.data.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomUserDetail implements UserDetails {
    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities; //ROLE_ADMIN, ROLE_CLIENT
    private Boolean status;

    public CustomUserDetail(User user) {
        List<Role> roles = new ArrayList<>();
        roles.add(user.getRole());
        List<GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.authorities = authorities;
        this.status = user.isStatus();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return status;
    }
}
