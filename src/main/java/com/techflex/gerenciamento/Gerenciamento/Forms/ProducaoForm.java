package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record ProducaoForm(
        @NotBlank
        String tamanho,
        @Enumerated
        DensidadeEnum densidadeEnum,
        @NotNull
        double quantidadeMilheiro,
        @NotNull
        double pesoMilheiro,
        @NotNull
        double apara,
        @NotBlank
        String nomeOperador,
        @NotBlank
        String maquina,
        LocalDate data
) {
}
