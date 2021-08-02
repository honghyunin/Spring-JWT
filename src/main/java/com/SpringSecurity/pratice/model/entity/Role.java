package com.SpringSecurity.pratice.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_ADMIN, ROLE_NOT_PERMIT;

    @Override
    public String getAuthority() {
        return name();
    }
}
