package com.remedios.dtos;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizarRemedio(
        @NotNull
        long id,
        String nome,
        Via via,
        Laboratorio laboratorio
    ) {

}
