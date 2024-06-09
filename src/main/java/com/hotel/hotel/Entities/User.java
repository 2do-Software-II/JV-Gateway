package com.hotel.hotel.Entities;

import java.util.Collection;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "User")
public class User implements UserDetails {

    @Id
    private String id;
    private String name;
    private String password;
    private String email;

    @DBRef
    private Role role;

    public User() {
    }

    public User(String name, String password, String email, Role role) {
        this.name = name;
        this.password = password;
        this.role = role;
        this.email = email;
    }

    // return list the roles of the user
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // return List.of(new SimpleGrantedAuthority(roleEnum.name()));
        return List.of(new SimpleGrantedAuthority("ADMIN"), new SimpleGrantedAuthority("CUSTOMER"),
                new SimpleGrantedAuthority("EMPLOYEE"));
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
