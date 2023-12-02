package com.techflex.gerenciamento.Gerenciamento.Dtos;

import com.techflex.gerenciamento.Gerenciamento.Entities.EntradasEntity;
import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.TipoEnum;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record EntradasDTO(
        Long id,
        TipoEnum tipoEnum,
        DensidadeEnum densidadeEnum,
        String modelo,
        double quantidadePeso,
        double pesoResina,
        LocalDate data
) {
    public EntradasDTO(EntradasEntity entradasEntity){
        this(
                entradasEntity.getId(),
                entradasEntity.getTipoEnum(),
                entradasEntity.getDensidadeEnum(),
                entradasEntity.getModelo(),
                entradasEntity.getQuantidadePeso(),
                entradasEntity.getPesoResina(),
                entradasEntity.getData()
        );
    }
}
