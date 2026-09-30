package com.gustavo.gerenciadorDeTarefas.Tarefa;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioResumoDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    @PostMapping
    public TarefaResponseDTO registrarTarefa(@Valid @RequestBody TarefaRequestDTO tarefaRequestDTO){
        TarefaModel tarefaSalva = tarefaService.registrarTarefa(
                tarefaRequestDTO.funcionarioId(),
                tarefaRequestDTO.nome(),
                tarefaRequestDTO.descricao(),
                tarefaRequestDTO.data(),
                tarefaRequestDTO.prioridadeTarefa()
        );

        FuncionarioResumoDTO funcionarioResumo = new FuncionarioResumoDTO(
                tarefaSalva.getFuncionario().getId(),
                tarefaSalva.getFuncionario().getNome()
        );

        return new TarefaResponseDTO(
                tarefaSalva.getId(),
                tarefaSalva.getNome(),
                tarefaSalva.getDescricao(),
                tarefaSalva.getData(),
                tarefaSalva.getStatusTarefa(),
                tarefaSalva.getPrioridadeTarefa(),
                funcionarioResumo
        );

    }
}
