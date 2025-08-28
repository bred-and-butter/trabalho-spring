package com.example.demo.DBEntities.Visita;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class VisitaId implements Serializable {

    @Column(name = "cpf_cliente")
    private String cpfCliente;

    @Column(name = "cnpj_cliente")
    private String cnpjCliente;

    @Column(name = "numero_matricula_imovel")
    private String numeroMatriculaImovel;

    @Column(name = "cpf_corretor")
    private String cpfCorretor;

    @Column(name = "cnpj_corretor")
    private String cnpjCorretor;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;

    public String getCpfCliente() {
        return cpfCliente;
    }

    public String getCnpjCliente() {
        return cnpjCliente;
    }

    public String getNumeroMatriculaImovel() {
        return numeroMatriculaImovel;
    }

    public String getCpfCorretor() {
        return cpfCorretor;
    }

    public String getCnpjCorretor() {
        return cnpjCorretor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public VisitaId() {}

    public VisitaId(String cpfCliente, String cnpjCliente, String numeroMatriculaImovel,
                    String cpfCorretor, String cnpjCorretor, LocalDateTime dataHora) {
        this.cpfCliente = cpfCliente;
        this.cnpjCliente = cnpjCliente;
        this.numeroMatriculaImovel = numeroMatriculaImovel;
        this.cpfCorretor = cpfCorretor;
        this.cnpjCorretor = cnpjCorretor;
        this.dataHora = dataHora;
    }

    // getters/setters
    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public void setCnpjCliente(String cnpjCliente) {
        this.cnpjCliente = cnpjCliente;
    }

    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
    }

    public void setCpfCorretor(String cpfCorretor) {
        this.cpfCorretor = cpfCorretor;
    }

    public void setCnpjCorretor(String cnpjCorretor) {
        this.cnpjCorretor = cnpjCorretor;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
}
