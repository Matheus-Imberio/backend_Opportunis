package com.bcc.projeto.dtos;

import com.bcc.projeto.entities.User;

public record ResponseDTO (String email) {
        public ResponseDTO(User user) {
            this(user.getEmail());
        }
    }

