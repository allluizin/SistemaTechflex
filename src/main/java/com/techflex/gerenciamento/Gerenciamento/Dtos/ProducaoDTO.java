package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.ProducaoEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;

import java.time.LocalDate;

public record ProducaoDTO(
        Long id,
        String tamanho,
        DensidadeEnum densidadeEnum,
        double quantidadeMilheiro,
        double pesoMilheiro,
        double pesoTotal,
        double apara,
        String nomeOperador,
        String maquina,
        LocalDate data
) {
    public ProducaoDTO(ProducaoEntity producao){
       this(
        producao.getId(),
        producao.getTamanho(),
        producao.getDensidadeEnum(),
        producao.getQuantidadeMilheiro(),
        producao.getPesoMilheiro(),
        producao.getPesoTotal(),
        producao.getApara(),
        producao.getNomeOperador(),
        producao.getMaquina(),
        producao.getData()
       );
    }

}
