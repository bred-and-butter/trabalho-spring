package com.example.demo.DBEntities.Imovel.UnidadeResidencial.Apartamento;

import com.example.demo.DBEntities.Imovel.UnidadeResidencial.UnidadeResidencial;

import jakarta.persistence.*;

@Entity
public class Apartamento {

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private UnidadeResidencial unidadeResidencial;

    @Column(name = "numero_apartamento", length = 100)
    private String numeroApartamento;

    private Integer andar;

    @Column(name = "possui_elevador")
    private Boolean possuiElevador;

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

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public Boolean getPossuiElevador() {
        return possuiElevador;
    }

    public void setPossuiElevador(Boolean possuiElevador) {
        this.possuiElevador = possuiElevador;
    }

    public String getNumeroApartamento() {
        return numeroApartamento;
    }

    public void numeroApartamento(String numeroApartamento) {
        this.numeroApartamento = numeroApartamento;
    }
}