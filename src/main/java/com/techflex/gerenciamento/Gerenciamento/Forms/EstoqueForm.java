package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;

public record EstoqueForm(
        @NotBlank(message = "Nao pode mandar nulo")
        String tamanho,
        @Enumerated
        DensidadeEnum densidadeEnum,
        @DecimalMin(value = "0.5", message = "nao pode mandar quantidade inferior a meio milheiro")
        double quantidadeMilheiro,
        double pesoMilheiro
        ) {
}
