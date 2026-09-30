package com.gustavo.gerenciadorDeTarefas.Tarefa;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioResumoDTO;

import java.time.LocalDate;

public record TarefaResponseDTO(

        Long id,
        String nome,
        String descricao,
        LocalDate data,
        StatusTarefa statusTarefa,
        PrioridadeTarefa prioridadeTarefa,
        FuncionarioResumoDTO funcionarioResumoDTO
) {
}
