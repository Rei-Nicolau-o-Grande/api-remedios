package com.remedios.models;

import com.remedios.dtos.DadosAtualizarRemedio;
import com.remedios.dtos.DadosCadastroRemedio;
import com.remedios.dtos.Laboratorio;
import com.remedios.dtos.Via;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "remedio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Remedio {

    public Remedio(DadosCadastroRemedio dados) {
        this.nome = dados.nome();
        this.via = dados.via();
        this.lote = dados.lote();
        this.quantidade = dados.quantidade();
        this.validade = dados.validade();
        this.laboratorio = dados.laboratorio();
        this.ativo = true;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private Via via;

    private String lote;

    private int quantidade;

    private LocalDate validade;

    @Enumerated(EnumType.STRING)
    private Laboratorio laboratorio;

    private boolean ativo;

    public void reativar() {
        this.ativo = true;
    }

    public void atualizarInformacoes(@Valid DadosAtualizarRemedio dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.via() != null) {
            this.via = dados.via();
        }

        if (dados.laboratorio() != null) {
            this.laboratorio = dados.laboratorio();
        }

    }

}
