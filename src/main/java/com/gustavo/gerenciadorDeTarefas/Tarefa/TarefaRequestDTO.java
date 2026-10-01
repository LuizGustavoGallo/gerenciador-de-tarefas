package com.gustavo.gerenciadorDeTarefas.Tarefa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record TarefaRequestDTO(

        @NotBlank(message = "Informe o nome da Tarefa") String nome,

        @NotBlank(message = "Informe a descricao da tarefa") String descricao,

        @NotNull(message = "Informe a data")LocalDate data,

        @NotNull(message = "Informe a prioridade") PrioridadeTarefa prioridadeTarefa
) {}
