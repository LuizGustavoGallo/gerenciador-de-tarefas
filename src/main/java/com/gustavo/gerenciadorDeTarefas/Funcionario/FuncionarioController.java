package com.gustavo.gerenciadorDeTarefas.Funcionario;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping
    public FuncionarioResponseDTO registrarFuncionario(@Valid @RequestBody FuncionarioRequestDTO  funcionarioRequestDTO){
        FuncionarioModel funcionario = new FuncionarioModel(
                funcionarioRequestDTO.nome(),
                funcionarioRequestDTO.email(),
                funcionarioRequestDTO.senha()
        );

        FuncionarioModel funcionarioSalvo = funcionarioService.registrarFuncionario(funcionario);

        return new FuncionarioResponseDTO(
                funcionarioSalvo.getId(),
                funcionarioSalvo.getNome(),
                funcionarioSalvo.getEmail()
        );
    }


}
