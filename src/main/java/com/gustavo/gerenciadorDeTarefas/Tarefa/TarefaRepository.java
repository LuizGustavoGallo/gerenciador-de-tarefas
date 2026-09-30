package com.gustavo.gerenciadorDeTarefas.Tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TarefaRepository extends JpaRepository<TarefaModel, Long> {

    List<TarefaModel> findByFuncionarioId(Long funcionarioId);
}
