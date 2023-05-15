package com.R2S.R2Sshop.config;

import com.R2S.R2Sshop.data.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class CustomUserDetail implements UserDetails {
    private final String username;
    private final String password;
    private final Set<GrantedAuthority> authorities; //ROLE_ADMIN, ROLE_CLIENT
    private final Boolean status;

    public CustomUserDetail(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.status = user.isStatus();
        this.authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().getName()));
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
