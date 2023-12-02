package com.techflex.gerenciamento.Gerenciamento.Entities;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Enums.EstadoEnum;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.PedidosForm;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "pedidos")
public class PedidosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cliente;
    private String tamanho;
    private double quantidadeMilheiro;
    @Enumerated(EnumType.STRING)
    private DensidadeEnum densidadeEnum;
    private LocalDate data;
    @Enumerated(EnumType.STRING)
    private EstadoEnum estadoEnum;

    public PedidosEntity() {}

    public PedidosEntity(Long id, String cliente, String tamanho, double quantidadeMilheiro, DensidadeEnum densidadeEnum, LocalDate data, EstadoEnum estadoEnum) {
        this.id = id;
        this.cliente = cliente;
        this.tamanho = tamanho;
        this.quantidadeMilheiro = quantidadeMilheiro;
        this.densidadeEnum = densidadeEnum;
        this.data = data;
        this.estadoEnum = estadoEnum;
    }

    public PedidosEntity(PedidosForm pedidosForm) {
        this.cliente = pedidosForm.cliente();
        this.tamanho = pedidosForm.tamanho();
        this.quantidadeMilheiro = pedidosForm.quantidadeMilheiro();
        this.densidadeEnum = pedidosForm.densidadeEnum();
        this.data = pedidosForm.data();
        this.estadoEnum = pedidosForm.estadoEnum();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public double getQuantidadeMilheiro() {
        return quantidadeMilheiro;
    }

    public void setQuantidadeMilheiro(double quantidadeMilheiro) {
        this.quantidadeMilheiro = quantidadeMilheiro;
    }

    public DensidadeEnum getDensidadeEnum() {
        return densidadeEnum;
    }

    public void setDensidadeEnum(DensidadeEnum densidadeEnum) {
        this.densidadeEnum = densidadeEnum;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public EstadoEnum getEstadoEnum() {
        return estadoEnum;
    }

    public void setEstadoEnum(EstadoEnum estadoEnum) {
        this.estadoEnum = estadoEnum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PedidosEntity that = (PedidosEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void atualizarPedidos(PedidosAtualizarForm pedidosAtualizarForm) {
        if(pedidosAtualizarForm.cliente() != null) {
            this.cliente = pedidosAtualizarForm.cliente();
        }
        if(pedidosAtualizarForm.tamanho() != null) {
            this.tamanho = pedidosAtualizarForm.tamanho();
        }
        if(pedidosAtualizarForm.quantidadeMilheiro() != 0) {
            this.quantidadeMilheiro = pedidosAtualizarForm.quantidadeMilheiro();
        }
        if(pedidosAtualizarForm.densidadeEnum() != null) {
            this.densidadeEnum = pedidosAtualizarForm.densidadeEnum();
        }
        if(pedidosAtualizarForm.data() != null) {
            this.data = pedidosAtualizarForm.data();
        }
        if(pedidosAtualizarForm.estadoEnum() != null) {
            this.estadoEnum = pedidosAtualizarForm.estadoEnum();
        }
    }
}
