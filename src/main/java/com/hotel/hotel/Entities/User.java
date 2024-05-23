package com.hotel.hotel.Entities;

import java.util.Collection;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hotel.hotel.Global.RoleEnum;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// @Data
@Document(collection = "User")
public class User implements UserDetails {

    private String id;
    private String name;
    private String password;
    private String email;
    private String role;

    private RoleEnum roleEnum;

    public User() {
    }

    public User(String name, String password, String email, String role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    // return list the roles of the user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return List.of(new SimpleGrantedAuthority(roleEnum.name()));
        return List.of(new SimpleGrantedAuthority("ADMIN"));
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
        return true;
    }
}
