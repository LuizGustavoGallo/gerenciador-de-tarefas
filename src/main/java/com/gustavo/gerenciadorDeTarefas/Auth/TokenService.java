package com.gustavo.gerenciadorDeTarefas.Auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;

@Service
public class TokenService {

    private final SecretKey chave;

    public TokenService(@Value("${jwt.secret}") String segredo){
        this.chave = Keys.hmacShaKeyFor(segredo.getBytes());
    }

    public String gerarToken(String email){
        long agora = System.currentTimeMillis();
        long expiracao = agora + 1000 * 60 * 60 * 2; //2 horas

        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date(agora))
                .expiration(new Date(expiracao))
                .signWith(chave)
                .compact();
    }

    public String extrairEmail(String token){
        return Jwts.parser()
                .verifyWith(chave)
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }
}
