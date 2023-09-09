package com.remedios.controllers;

import com.remedios.dtos.DadosAtualizarRemedio;
import com.remedios.dtos.DadosCadastroRemedio;
import com.remedios.dtos.DadosDetalhamentoRemedio;
import com.remedios.dtos.DadosListagemRemedio;
import com.remedios.models.Remedio;
import com.remedios.repositories.RemedioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/remedios")
public class RemedioController {

    @Autowired
    private RemedioRepository remedioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> cadastrar (@RequestBody @Valid DadosCadastroRemedio dados, UriComponentsBuilder uriBuilder) {
        var remedio = new Remedio(dados);
        remedioRepository.save(remedio);

        var uri = uriBuilder.path("/remedios/{id}").buildAndExpand(remedio.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoRemedio(remedio));
    }

    @GetMapping
    public ResponseEntity<List<DadosListagemRemedio>> listar () {
        var lista = remedioRepository.findAllByAtivoTrue().stream().map(DadosListagemRemedio::new).toList();

        return ResponseEntity.ok(lista);
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<DadosDetalhamentoRemedio> atualizar (@RequestBody @Valid DadosAtualizarRemedio dados) {
        Remedio remedio = remedioRepository.getReferenceById(dados.id());
        remedio.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> excluir (@PathVariable long id) {
        remedioRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/inativar/{id}")
    @Transactional
    public ResponseEntity<Void> inativar (@PathVariable long id) {
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.setAtivo(false);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ativar/{id}")
    @Transactional
    public ResponseEntity<Void> ativar (@PathVariable long id) {
        Remedio remedio = remedioRepository.getReferenceById(id);
        remedio.reativar();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhamentoRemedio> detalhar (@PathVariable long id) {
        Remedio remedio = remedioRepository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoRemedio(remedio));
    }

}
