package com.bcc.projeto.entities.enums;

public enum Roles {
    ADMIN("admin"),
    ENTERPRISE("enterprise"),
    CANDIDATE("candidate");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}