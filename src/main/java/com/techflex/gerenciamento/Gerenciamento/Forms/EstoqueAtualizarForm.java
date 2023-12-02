package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import jakarta.validation.constraints.NotNull;

public record EstoqueAtualizarForm(
        Long id,
        String tamanho,
        DensidadeEnum densidadeEnum,
        double quantidadeMilheiro,
        double pesoMilheiro

) {

}
