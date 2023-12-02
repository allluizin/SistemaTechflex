package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.PedidosEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.EstadoEnum;

import java.time.LocalDate;

public record DetalhamentoPedidosDTO(

        Long id,
        String cliente,
        String tamanho,
        double quantidadeMilheiro,
        DensidadeEnum densidadeEnum,
        LocalDate data,
        EstadoEnum estadoEnum

) {

    public DetalhamentoPedidosDTO(PedidosEntity pedido) {
        this(
                pedido.getId(),
                pedido.getCliente(),
                pedido.getTamanho(),
                pedido.getQuantidadeMilheiro(),
                pedido.getDensidadeEnum(),
                pedido.getData(),
                pedido.getEstadoEnum()
        );
    }
}
