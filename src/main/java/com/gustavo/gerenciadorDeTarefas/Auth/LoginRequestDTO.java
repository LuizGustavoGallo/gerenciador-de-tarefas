package com.gustavo.gerenciadorDeTarefas.Auth;

import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @NotBlank(message = "Informe o email") String email,
        @NotBlank(message = "Informe a senha") String senha
) {
}
