package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.EstadoEnum;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record PedidosForm(
        @NotBlank(message = "nao pode ser nulo")
        String cliente,
        @NotBlank(message = "nao pode ser nulo")
        String tamanho,
        double quantidadeMilheiro,
        @Enumerated
        DensidadeEnum densidadeEnum,
        LocalDate data,
        @Enumerated
        EstadoEnum estadoEnum
) {
}
