package com.example.demo.DBEntities.Imovel.UnidadeComercial.PredioComercial;

import com.example.demo.DBEntities.Imovel.UnidadeComercial.UnidadeComercial;

import jakarta.persistence.*;

@Entity
public class PredioComercial {

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private UnidadeComercial unidadeComercial;

    @Column(name = "total_andares")
    private Integer totalAndares;

    @Column(name = "numero_salas")
    private Integer numeroSalas;

    @Column(name = "possui_estacionamento")
    private Boolean possuiEstacionamento;

    // Getters e Setters
    public String getNumeroMatriculaImovel() {
        return numeroMatriculaImovel;
    }

    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
    }

    public UnidadeComercial getUnidadeComercial() {
        return unidadeComercial;
    }

    public void setUnidadeComercial(UnidadeComercial unidadeComercial) {
        this.unidadeComercial = unidadeComercial;
    }

    public Integer getTotalAndares() {
        return totalAndares;
    }

    public void setTotalAndares(Integer totalAndares) {
        this.totalAndares = totalAndares;
    }

    public Integer getNumeroSalas() {
        return numeroSalas;
    }

    public void setNumeroSalas(Integer numeroSalas) {
        this.numeroSalas = numeroSalas;
    }

    public Boolean getPossuiEstacionamento() {
        return possuiEstacionamento;
    }

    public void setPossuiEstacionamento(Boolean possuiEstacionamento) {
        this.possuiEstacionamento = possuiEstacionamento;
    }
}