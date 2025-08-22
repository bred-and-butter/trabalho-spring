package com.example.demo.DBEntities.Imovel.Terreno;

import com.example.demo.DBEntities.Imovel.Imovel;

import jakarta.persistence.*;

@Entity
public class Terreno {

    @Id
    @Column(name = "numero_matricula_imovel", nullable = false)
    private String numeroMatriculaImovel;

    @OneToOne
    @MapsId
    @JoinColumn(name = "numero_matricula_imovel")
    private Imovel imovel;

    @Column(length = 100)
    private String topografia;

    @Column(name = "tipo_solo", length = 100)
    private String tipoSolo;

    // Getters e Setters

    public String getNumeroMatriculaImovel() {
        return numeroMatriculaImovel;
    }

    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
    }

    public String getTopografia() {
        return topografia;
    }

    public void setTopografia(String topografia) {
        this.topografia = topografia;
    }

    public String getTipoSolo() {
        return tipoSolo;
    }

    public void setTipoSolo(String tipoSolo) {
        this.tipoSolo = tipoSolo;
    }
}