package com.example.demo.DBEntities.Imovel.UnidadeResidencial;

import jakarta.persistence.*;

import java.math.BigDecimal;

import com.example.demo.DBEntities.Imovel.Imovel;

@Entity
public class UnidadeResidencial{

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private Imovel imovel;

    private Integer numeroQuartos;
    private Integer numeroBanheiros;
    private Integer numeroSuites;

    @Column(name = "area_construida", precision = 10, scale = 2)
    private BigDecimal areaConstruida;

    private Integer numeroVagasGaragem;

    private String descricao;

    // Getters e Setters

    public Integer getNumeroQuartos() {
        return numeroQuartos;
    }

    public void setNumeroQuartos(Integer numeroQuartos) {
        this.numeroQuartos = numeroQuartos;
    }

    public Integer getNumeroBanheiros() {
        return numeroBanheiros;
    }

    public void setNumeroBanheiros(Integer numeroBanheiros) {
        this.numeroBanheiros = numeroBanheiros;
    }

    public Integer getNumeroSuites() {
        return numeroSuites;
    }

    public void setNumeroSuites(Integer numeroSuites) {
        this.numeroSuites = numeroSuites;
    }

    public BigDecimal getAreaConstruida() {
        return areaConstruida;
    }

    public void setAreaConstruida(BigDecimal areaConstruida) {
        this.areaConstruida = areaConstruida;
    }

    public Integer getNumeroVagasGaragem() {
        return numeroVagasGaragem;
    }

    public void setNumeroVagasGaragem(Integer numeroVagasGaragem) {
        this.numeroVagasGaragem = numeroVagasGaragem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}