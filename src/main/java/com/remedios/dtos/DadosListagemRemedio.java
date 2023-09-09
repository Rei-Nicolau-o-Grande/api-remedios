package com.remedios.dtos;

import com.remedios.models.Remedio;

import java.time.LocalDate;

public record DadosListagemRemedio(long id, String nome, Via via, String lote, LocalDate validade,
                                   Laboratorio laboratorio) {

    public DadosListagemRemedio(Remedio remedio) {
        this(
                remedio.getId(),
                remedio.getNome(),
                remedio.getVia(),
                remedio.getLote(),
                remedio.getValidade(),
                remedio.getLaboratorio()
        );
    }
}
