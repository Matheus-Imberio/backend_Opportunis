package com.bcc.projeto.entities;

import java.io.Serial;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class User implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
}