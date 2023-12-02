package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;

import java.time.LocalDate;

public record ProducaoAtualizarForm(
        String tamanho,
        DensidadeEnum densidadeEnum,
        double quantidadeMilheiro,
        double pesoMilheiro,
        double apara,
        String nomeOperador,
        String maquina,
        LocalDate data
) {
}
