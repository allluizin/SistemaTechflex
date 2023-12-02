package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.EstoqueEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;

public record EstoqueDTO(
        Long id,
        String tamanho,
        DensidadeEnum densidadeEnum,
        double quantidadeMilheiro,
        double pesoMilheiro,
        double pesoTotal
) {
    public EstoqueDTO(EstoqueEntity estoqueEntity){
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
