package com.gustavo.gerenciadorDeTarefas.Auth;

import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioModel;
import com.gustavo.gerenciadorDeTarefas.Funcionario.FuncionarioRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Collections;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final FuncionarioRepository funcionarioRepository;

    public SecurityFilter(TokenService tokenService, FuncionarioRepository funcionarioRepository) {
        this.tokenService = tokenService;
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String cabecalho = request.getHeader("Authorization");

        if(cabecalho != null){
           String token = cabecalho.replace("Bearer ", "");
           String email = tokenService.extrairEmail(token);

           FuncionarioModel funcionario = funcionarioRepository.findByEmail(email).orElse(null);

           if (funcionario != null){
                var autenticacao = new UsernamePasswordAuthenticationToken(funcionario, null, Collections.emptyList());
                 SecurityContextHolder.getContext().setAuthentication(autenticacao);
           }
        }
        filterChain.doFilter(request, response);

    }
}
