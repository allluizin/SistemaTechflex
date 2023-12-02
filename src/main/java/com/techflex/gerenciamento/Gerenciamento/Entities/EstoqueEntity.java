package com.techflex.gerenciamento.Gerenciamento.Entities;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.EstoqueForm;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "estoque")
public class EstoqueEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tamanho;
    @Enumerated(EnumType.STRING)
    private DensidadeEnum densidadeEnum;
    private double quantidadeMilheiro;
    private double pesoMilheiro;
    private double pesoTotal;

    public EstoqueEntity(){}
    public EstoqueEntity(Long id, String tamanho, DensidadeEnum densidadeEnum, double quantidadeMilheiro, double pesoMilheiro, double pesoTotal) {
        this.id = id;
        this.tamanho = tamanho;
        this.densidadeEnum = densidadeEnum;
        this.quantidadeMilheiro = quantidadeMilheiro;
        this.pesoMilheiro = pesoMilheiro;
        this.pesoTotal = pesoTotal;
    }

    public EstoqueEntity(EstoqueForm estoqueForm) {
        this.tamanho = estoqueForm.tamanho();
        this.densidadeEnum = estoqueForm.densidadeEnum();
        this.quantidadeMilheiro = estoqueForm.quantidadeMilheiro();
        this.pesoMilheiro = estoqueForm.pesoMilheiro();
        this.pesoTotal = estoqueForm.pesoMilheiro() * estoqueForm.quantidadeMilheiro();
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public DensidadeEnum getDensidadeEnum() {
        return densidadeEnum;
    }

    public void setDensidadeEnum(DensidadeEnum densidadeEnum) {
        this.densidadeEnum = densidadeEnum;
    }

    public double getQuantidadeMilheiro() {
        return quantidadeMilheiro;
    }

    public void setQuantidadeMilheiro(double quantidadeMilheiro) {
        this.quantidadeMilheiro = quantidadeMilheiro;
    }

    public double getPesoMilheiro() {
        return pesoMilheiro;
    }

    public void setPesoMilheiro(double pesoMilheiro) {
        this.pesoMilheiro = pesoMilheiro;
    }
    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstoqueEntity that = (EstoqueEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public void atualizarEstoque(EstoqueAtualizarForm estoqueAtualizarForm) {
        if(estoqueAtualizarForm.tamanho() != null) {
            this.tamanho = estoqueAtualizarForm.tamanho();
        }
        if(estoqueAtualizarForm.densidadeEnum() != null) {
            this.densidadeEnum = estoqueAtualizarForm.densidadeEnum();
        }
        if(estoqueAtualizarForm.quantidadeMilheiro() != 0) {
            this.quantidadeMilheiro = estoqueAtualizarForm.quantidadeMilheiro();
        }
        if(estoqueAtualizarForm.pesoMilheiro() != 0){
            this.pesoMilheiro = estoqueAtualizarForm.pesoMilheiro();
        }
    }
}
