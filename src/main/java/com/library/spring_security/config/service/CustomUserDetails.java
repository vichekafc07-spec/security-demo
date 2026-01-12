package com.library.spring_security.config.service;

import com.library.spring_security.domain.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;

@Getter
public class CustomUserDetails implements UserDetails {

    private final String email;
    private final String password;
    private final boolean enableds;
    private final Collection<? extends GrantedAuthority> authorities;

    private CustomUserDetails(
                              String email,
                              String password,
                              boolean enabled,
                              Collection<? extends GrantedAuthority> authorities) {
        this.email = email;
        this.password = password;
        this.enableds = enabled;
        this.authorities = authorities;
    }
    public static CustomUserDetails from(User user){
        return new CustomUserDetails(
                user.getEmail(),
                user.getPassword(),
                user.isEnabled(),
                user.getRoles()
                        .stream()
                        .map(role -> new  SimpleGrantedAuthority("ROLE_" + role.getName()))
                        .toList()
        );
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
        return email;
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
        return isEnableds();
    }
}
