package com.gustavo.gerenciadorDeTarefas.Funcionario;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;

    public FuncionarioService(FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder) {
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

   public FuncionarioModel registrarFuncionario(FuncionarioModel novoFuncionario){
        novoFuncionario.setSenha(passwordEncoder.encode(novoFuncionario.getSenha()));
        return funcionarioRepository.save(novoFuncionario);
   }
}
