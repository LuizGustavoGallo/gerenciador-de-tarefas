package com.gustavo.gerenciadorDeTarefas.Auth;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioModel;
import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioRepository;
import jakarta.validation.Valid;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final FuncionarioRepository funcionarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;

    public AuthController(FuncionarioRepository funcionarioRepository, PasswordEncoder passwordEncoder, TokenService tokenService) {
        this.funcionarioRepository = funcionarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.tokenService = tokenService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@Valid @RequestBody LoginRequestDTO loginRequestDTO){

        FuncionarioModel funcionario = funcionarioRepository.findByEmail(loginRequestDTO.email())
                .orElseThrow(() -> new CredenciaisInvalidasException("Email ou senha inválidos"));

        if (!passwordEncoder.matches(loginRequestDTO.senha(), funcionario.getSenha())){
            throw new CredenciaisInvalidasException("Email ou senha inválidos");
        }

        String token = tokenService.gerarToken(funcionario.getEmail());

        return new LoginResponseDTO(token);
    }
}
