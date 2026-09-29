package com.gustavo.gerenciadorDeTarefas.Funcionario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record FuncionarioRequestDTO(

        @Pattern(regexp = "^[a-zA-ZÀ-ÿ\\s]+$", message = "Nome deve conter apenas letras")
        @NotBlank(message = "Informe seu nome.") String nome,

        @Email(message = "Infome email corretamente")
        @NotBlank(message = "Informe seu email") String email,

        @Size(min = 5, message = "Senha deve ter no mínimo 5 caracteres")
        @NotBlank(message = "Informe sua senha") String senha
) {
}
