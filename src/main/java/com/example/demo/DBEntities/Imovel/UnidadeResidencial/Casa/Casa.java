package com.example.demo.DBEntities.Imovel.UnidadeResidencial.Casa;

import com.example.demo.DBEntities.Imovel.UnidadeResidencial.UnidadeResidencial;

import jakarta.persistence.*;

@Entity
public class Casa {

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private UnidadeResidencial unidadeResidencial;

    @Column(name = "possui_quintal")
    private Boolean possuiQuintal;

    @Column(name = "numero_pavimentos")
    private Integer numeroPavimentos;

    // Getters e Setters

    public String getNumeroMatriculaImovel() {
        return numeroMatriculaImovel;
    }

    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
    }

    public UnidadeResidencial getUnidadeResidencial() {
        return unidadeResidencial;
    }

    public void setUnidadeResidencial(UnidadeResidencial unidadeResidencial) {
        this.unidadeResidencial = unidadeResidencial;
    }

    public Boolean getPossuiQuintal() {
        return possuiQuintal;
    }

    public void setPossuiQuintal(Boolean possuiQuintal) {
        this.possuiQuintal = possuiQuintal;
    }

    public Integer getNumeroPavimentos() {
        return numeroPavimentos;
    }

    public void setNumeroPavimentos(Integer numeroPavimentos) {
        this.numeroPavimentos = numeroPavimentos;
    }
}