package com.gustavo.gerenciadorDeTarefas.Tarefa;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioModel;
import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioNaoEncontradoException;
import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TarefaService {

    private final TarefaRepository tarefaRepository;
    private final FuncionarioRepository funcionarioRepository;

    public TarefaService(TarefaRepository tarefaRepository, FuncionarioRepository funcionarioRepository) {
        this.tarefaRepository = tarefaRepository;
        this.funcionarioRepository = funcionarioRepository;
    }

    public TarefaModel registrarTarefa(Long funcionarioId, String nome, String descricao, LocalDate data, PrioridadeTarefa prioridade){

        FuncionarioModel funcionario = funcionarioRepository.findById(funcionarioId)
                .orElseThrow(() -> new FuncionarioNaoEncontradoException("Funcionario não encontrado"));

        TarefaModel tarefa = new TarefaModel(nome, descricao, data, prioridade, funcionario);
        return tarefaRepository.save(tarefa);
    }
}
