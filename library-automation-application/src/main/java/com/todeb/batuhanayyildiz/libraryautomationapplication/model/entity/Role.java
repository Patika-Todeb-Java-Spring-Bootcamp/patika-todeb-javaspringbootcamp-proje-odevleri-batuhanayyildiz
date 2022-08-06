package com.todeb.batuhanayyildiz.libraryautomationapplication.model.entity;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN, ROLE_CLIENT, ROLE_EMPLOYEE;

    public String getAuthority() {
        return name();
    }
}
