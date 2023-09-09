package com.remedios.dtos;

import com.remedios.models.Remedio;

import java.time.LocalDate;

public record DadosDetalhamentoRemedio(
        long id,
        String nome,
        Via via,
        String lote,
        int quantidade,
        LocalDate validade,
        Laboratorio laboratorio,
        boolean ativo) {

        public DadosDetalhamentoRemedio (Remedio remedio) {
            this(
                    remedio.getId(),
                    remedio.getNome(),
                    remedio.getVia(),
                    remedio.getLote(),
                    remedio.getQuantidade(),
                    remedio.getValidade(),
                    remedio.getLaboratorio(),
                    remedio.isAtivo()
            );
        }
}
