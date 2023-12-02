package com.techflex.gerenciamento.Gerenciamento.Forms;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.TipoEnum;
import jakarta.persistence.Enumerated;

import java.time.LocalDate;

public record EntradasForm(
        @Enumerated
        TipoEnum tipoEnum,
        @Enumerated
        DensidadeEnum densidadeEnum,
        String modelo,
        double quantidadePeso,
        double pesoResina,
        LocalDate data
) {
}
