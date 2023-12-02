package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.EstoqueEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;

public record DetalhamentoEstoqueDTO(
        Long id,
        String tamanho,
        DensidadeEnum densidadeEnum,
        double quandidadeMilheiro,
        double pesoMilheiro,
        double pesoTotal

) {


    public DetalhamentoEstoqueDTO(EstoqueEntity estoqueEntity) {
        this(
                estoqueEntity.getId(),
                estoqueEntity.getTamanho(),
                estoqueEntity.getDensidadeEnum(),
                estoqueEntity.getQuantidadeMilheiro(),
                estoqueEntity.getPesoMilheiro(),
                estoqueEntity.getPesoTotal()
        );

    }
}
