package com.remedios.dtos;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record DadosCadastroRemedio(
    @NotBlank
    String nome,
    @Enumerated
    Via via,
    @NotBlank
    String lote,

    int quantidade,
    @Future
    LocalDate validade,
    @Enumerated
    Laboratorio laboratorio) {

}
