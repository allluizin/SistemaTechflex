package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.ProducaoEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record DetalhamentoProducaoDTO(
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

    public DetalhamentoProducaoDTO(ProducaoEntity producao) {
        this(
                producao.getId(),
                producao.getTamanho(),
                producao.getDensidadeEnum(),
                producao.getQuantidadeMilheiro(),
                producao.getPesoTotal(),
                producao.getPesoTotal(),
                producao.getApara(),
                producao.getNomeOperador(),
                producao.getMaquina(),
                producao.getData()
        );
    }
}
