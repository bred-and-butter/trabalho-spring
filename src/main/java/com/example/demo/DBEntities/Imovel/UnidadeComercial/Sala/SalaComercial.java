package com.example.demo.DBEntities.Imovel.UnidadeComercial.SalaComercial;

import com.example.demo.DBEntities.Imovel.UnidadeComercial.UnidadeComercial;

import jakarta.persistence.*;

@Entity
public class SalaComercial {

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private UnidadeComercial unidadeComercial;

    private Integer andar;

    @Column(name = "numero_sala")
    private String numeroSala;

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

    public Integer getAndar() {
        return andar;
    }

    public void setAndar(Integer andar) {
        this.andar = andar;
    }

    public String getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(String numeroSala) {
        this.numeroSala = numeroSala;
    }
}