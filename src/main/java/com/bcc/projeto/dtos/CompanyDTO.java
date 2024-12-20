package com.bcc.projeto.dtos;

import com.bcc.projeto.entities.Category;

public record CompanyDTO(String name, String email, String telephone, String password,
                         String cnpj, Category category) {
}
