package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.TipoEnum;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record EntradasAtualizarForm(
        Long id,
        TipoEnum tipoEnum,
        DensidadeEnum densidadeEnum,
        String modelo,
        double quantidadePeso,
        double pesoResina,
        LocalDate data
) {
}
