package com.bcc.projeto.dtos;

import com.bcc.projeto.entities.User;

public record UserDTO(String email, String password) {
    public UserDTO(User user) {
        this(user.getEmail(), user.getPassword());
    }
}
