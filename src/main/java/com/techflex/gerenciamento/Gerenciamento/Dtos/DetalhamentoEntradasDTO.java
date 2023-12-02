package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.EntradasEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.TipoEnum;

import java.time.LocalDate;

public record DetalhamentoEntradasDTO(
        Long id,
        TipoEnum tipoEnum,
        DensidadeEnum densidadeEnum,
        String tamanhoBobinas,
        double quantidadeBobinas,
        double pesoResina,
        LocalDate data

) {
    public DetalhamentoEntradasDTO(EntradasEntity entrada) {
        this(
                entrada.getId(),
                entrada.getTipoEnum(),
                entrada.getDensidadeEnum(),
                entrada.getModelo(),
                entrada.getQuantidadePeso(),
                entrada.getPesoResina(),
                entrada.getData()
        );
    }
}
