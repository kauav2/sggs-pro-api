package com.mycompany.sggs_pro_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginRequestDTO {

    @NotBlank(message = "O login não pode estar vazio")
    private String login;

    @NotBlank(message = "A senha não pode estar vazia")
    private String senha;
}