package com.remedios.controllers;

import com.remedios.dtos.DadosAutenticao;
import com.remedios.dtos.DadosTokenJwtDto;
import com.remedios.models.Usuario;
import com.remedios.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager manager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<?> efetuarLogin (@RequestBody @Valid DadosAutenticao dados) {
        var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
        var autenticacao = manager.authenticate(token);

        var tokenjwt = tokenService.gerarToken((Usuario) autenticacao.getPrincipal());

        return ResponseEntity.ok(new DadosTokenJwtDto(tokenjwt));
    }
}
