package com.techflex.gerenciamento.Gerenciamento.Entities;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.TipoEnum;
import com.techflex.gerenciamento.Gerenciamento.Forms.EntradasAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EntradasForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosForm;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "entradas")
public class EntradasEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoEnum tipoEnum;
    @Enumerated(EnumType.STRING)
    private DensidadeEnum densidadeEnum;
    private String modelo;
    private double quantidadePeso;
    private double pesoResina;
    private LocalDate data;

    public EntradasEntity() {}
    public EntradasEntity(Long id, TipoEnum tipoEnum, DensidadeEnum densidadeEnum, String modelo, double quantidadePeso, double pesoResina, LocalDate data) {
        this.id = id;
        this.tipoEnum = tipoEnum;
        this.densidadeEnum = densidadeEnum;
        this.modelo = modelo;
        this.quantidadePeso = quantidadePeso;
        this.pesoResina = pesoResina;
        this.data = data;
    }

    public EntradasEntity(EntradasForm entradasForm) {
        this.tipoEnum = entradasForm.tipoEnum();
        this.densidadeEnum = entradasForm.densidadeEnum();
        this.modelo = entradasForm.modelo();
        this.quantidadePeso = entradasForm.quantidadePeso();
        this.pesoResina = entradasForm.pesoResina();
        this.data = entradasForm.data();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoEnum getTipoEnum() {
        return tipoEnum;
    }

    public void setTipoEnum(TipoEnum tipoEnum) {
        this.tipoEnum = tipoEnum;
    }

    public DensidadeEnum getDensidadeEnum() {
        return densidadeEnum;
    }

    public void setDensidadeEnum(DensidadeEnum densidadeEnum) {
        this.densidadeEnum = densidadeEnum;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getQuantidadePeso() {
        return quantidadePeso;
    }

    public void setQuantidadePeso(double quantidadePeso) {
        this.quantidadePeso = quantidadePeso;
    }

    public double getPesoResina() {
        return pesoResina;
    }

    public void setPesoResina(double pesoResina) {
        this.pesoResina = pesoResina;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EntradasEntity that = (EntradasEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public void atualizarEntradas(EntradasAtualizarForm entradasAtualizarForm) {
        if(entradasAtualizarForm.tipoEnum() != null) {
            this.tipoEnum = entradasAtualizarForm.tipoEnum();
        }
        if(entradasAtualizarForm.densidadeEnum() != null) {
            this.densidadeEnum = entradasAtualizarForm.densidadeEnum();
        }
        if(entradasAtualizarForm.modelo() != null) {
            this.modelo = entradasAtualizarForm.modelo();
        }
        if(entradasAtualizarForm.quantidadePeso() != 0) {
            this.quantidadePeso = entradasAtualizarForm.quantidadePeso();
        }
        if(entradasAtualizarForm.pesoResina() != 0) {
            this.pesoResina = entradasAtualizarForm.pesoResina();
        }
        if(entradasAtualizarForm.data() != null) {
            this.data = entradasAtualizarForm.data();
        }
    }
}
