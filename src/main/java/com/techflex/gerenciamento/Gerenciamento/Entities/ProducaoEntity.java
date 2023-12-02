package com.techflex.gerenciamento.Gerenciamento.Entities;

import com.techflex.gerenciamento.Gerenciamento.Enums.DensidadeEnum;
import com.techflex.gerenciamento.Gerenciamento.Forms.ProducaoAtualizarForm;
import com.techflex.gerenciamento.Gerenciamento.Forms.ProducaoForm;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "producao")
public class ProducaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tamanho;
    @Enumerated(EnumType.STRING)
    private DensidadeEnum densidadeEnum;
    private double quantidadeMilheiro;
    private double pesoMilheiro;
    private double pesoTotal;
    private double apara;
    private String nomeOperador;
    private String maquina;
    private LocalDate data;
    public ProducaoEntity() {
    }

    public ProducaoEntity(Long id, String tamanho, DensidadeEnum densidadeEnum,double quantidadeMilheiro, double pesoMilheiro, double pesoTotal, double apara, String nomeOperador, String maquina, LocalDate data) {
        this.id = id;
        this.tamanho = tamanho;
        this.densidadeEnum = densidadeEnum;
        this.quantidadeMilheiro = quantidadeMilheiro;
        this.pesoMilheiro = pesoMilheiro;
        this.pesoTotal = pesoTotal;
        this.apara = apara;
        this.nomeOperador = nomeOperador;
        this.maquina = maquina;
        this.data = data;
    }

    public ProducaoEntity(ProducaoForm producaoForm) {
        this.tamanho = producaoForm.tamanho();
        this.densidadeEnum = producaoForm.densidadeEnum();
        this.quantidadeMilheiro = producaoForm.quantidadeMilheiro();
        this.pesoMilheiro = producaoForm.pesoMilheiro();
        this.pesoTotal = producaoForm.quantidadeMilheiro() * producaoForm.pesoMilheiro();;
        this.apara = producaoForm.apara();
        this.nomeOperador = producaoForm.nomeOperador();
        this.maquina = producaoForm.maquina();
        this.data = producaoForm.data();
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

    public double getApara() {
        return apara;
    }

    public void setApara(double apara) {
        this.apara = apara;
    }

    public String getNomeOperador() {
        return nomeOperador;
    }

    public void setNomeOperador(String nomeOperador) {
        this.nomeOperador = nomeOperador;
    }

    public String getMaquina() {
        return maquina;
    }

    public void setMaquina(String maquina) {
        this.maquina = maquina;
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
        ProducaoEntity that = (ProducaoEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    public void atualizarProducao(ProducaoAtualizarForm producaoAtualizarForm) {
        if(producaoAtualizarForm.tamanho() != null) {
            this.tamanho = producaoAtualizarForm.tamanho();
        }
        if(producaoAtualizarForm.densidadeEnum() != null) {
            this.densidadeEnum = producaoAtualizarForm.densidadeEnum();
        }
        if(producaoAtualizarForm.quantidadeMilheiro() != 0) {
            this.quantidadeMilheiro = producaoAtualizarForm.quantidadeMilheiro();
        }
        if(producaoAtualizarForm.pesoMilheiro()!= 0) {
            this.pesoMilheiro = producaoAtualizarForm.pesoMilheiro();
        }
        if(producaoAtualizarForm.apara()!= 0) {
            this.apara = producaoAtualizarForm.apara();
        }
        if(producaoAtualizarForm.nomeOperador() != null) {
            this.nomeOperador = producaoAtualizarForm.nomeOperador();
        }
        if(producaoAtualizarForm.maquina() != null) {
            this.maquina = producaoAtualizarForm.maquina();
        }
        if(producaoAtualizarForm.data() != null) {
            this.data = producaoAtualizarForm.data();
        }
    }
}
