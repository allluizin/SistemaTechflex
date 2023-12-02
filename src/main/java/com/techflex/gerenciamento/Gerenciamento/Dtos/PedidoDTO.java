package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.PedidosEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.EstadoEnum;

import java.time.LocalDate;

public record PedidoDTO(
        Long id,
        String cliente,
        String tamanho,
        double quantidadeMilheiro,
        DensidadeEnum densidadeEnum,
        LocalDate data,
        EstadoEnum estadoEnum
) {
    public PedidoDTO(PedidosEntity pedidosEntity){
        this(
                pedidosEntity.getId(),
              pedidosEntity.getCliente(),
              pedidosEntity.getTamanho(),
              pedidosEntity.getQuantidadeMilheiro(),
              pedidosEntity.getDensidadeEnum(),
              pedidosEntity.getData(),
              pedidosEntity.getEstadoEnum()
        );
    }
}
