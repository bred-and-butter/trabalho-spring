package com.example.demo.DBEntities.Imovel.UnidadeComercial;

import jakarta.persistence.*;
import java.math.BigDecimal;

import com.example.demo.DBEntities.Imovel.Imovel;

@Entity
public class UnidadeComercial {

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private Imovel imovel;

    @Column(name = "area_util", precision = 10, scale = 2)
    private BigDecimal areaUtil;

    private String descricao;

    // Getters e Setters
    public String getNumeroMatriculaImovel() {
        return numeroMatriculaImovel;
    }

    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public BigDecimal getAreaUtil() {
        return areaUtil;
    }

    public void setAreaUtil(BigDecimal areaUtil) {
        this.areaUtil = areaUtil;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}