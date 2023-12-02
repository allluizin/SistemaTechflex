package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.EstadoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.cglib.core.Local;

import java.rmi.MarshalException;
import java.time.LocalDate;

public record PedidosAtualizarForm(
        Long id,
        String cliente,
        String tamanho,
        double quantidadeMilheiro,
        DensidadeEnum densidadeEnum,
        LocalDate data,
        EstadoEnum estadoEnum
) {
}
