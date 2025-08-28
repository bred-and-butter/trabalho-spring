package com.example.demo.DBEntities.Venda;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
public class VendaId implements Serializable {

    @Column(name = "numero_matricula_imovel")
    private String numeroMatriculaImovel;

    @Column(name = "cpf_cliente_comprador")
    private String cpfClienteComprador;

    @Column(name = "cnpj_cliente_comprador")
    private String cnpjClienteComprador;

    @Column(name = "cpf_proprietario_imovel")
    private String cpfProprietarioImovel;

    @Column(name = "cnpj_proprietario_imovel")
    private String cnpjProprietarioImovel;

    @Column(name = "cpf_corretor")
    private String cpfCorretor;

    @Column(name = "cnpj_corretor")
    private String cnpjCorretor;

    @Column(name = "data_venda")
    private LocalDateTime dataVenda;

    public VendaId() {}

    // construtor completo
    public VendaId(String numeroMatriculaImovel, String cpfClienteComprador, String cnpjClienteComprador,
                   String cpfProprietarioImovel, String cnpjProprietarioImovel,
                   String cpfCorretor, String cnpjCorretor, LocalDateTime dataVenda) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
        this.cpfClienteComprador = cpfClienteComprador;
        this.cnpjClienteComprador = cnpjClienteComprador;
        this.cpfProprietarioImovel = cpfProprietarioImovel;
        this.cnpjProprietarioImovel = cnpjProprietarioImovel;
        this.cpfCorretor = cpfCorretor;
        this.cnpjCorretor = cnpjCorretor;
        this.dataVenda = dataVenda;
    }

    // getters e setters
    public String getNumeroMatriculaImovel() {
        return numeroMatriculaImovel;
    }

    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) {
        this.numeroMatriculaImovel = numeroMatriculaImovel;
    }

    public String getCpfClienteComprador() {
        return cpfClienteComprador;
    }

    public void setCpfClienteComprador(String cpfClienteComprador) {
        this.cpfClienteComprador = cpfClienteComprador;
    }

    public String getCnpjClienteComprador() {
        return cnpjClienteComprador;
    }

    public void setCnpjClienteComprador(String cnpjClienteComprador) {
        this.cnpjClienteComprador = cnpjClienteComprador;
    }

    public String getCpfProprietarioImovel() {
        return cpfProprietarioImovel;
    }

    public void setCpfProprietarioImovel(String cpfProprietarioImovel) {
        this.cpfProprietarioImovel = cpfProprietarioImovel;
    }

    public String getCnpjProprietarioImovel() {
        return cnpjProprietarioImovel;
    }

    public void setCnpjProprietarioImovel(String cnpjProprietarioImovel) {
        this.cnpjProprietarioImovel = cnpjProprietarioImovel;
    }

    public String getCpfCorretor() {
        return cpfCorretor;
    }

    public void setCpfCorretor(String cpfCorretor) {
        this.cpfCorretor = cpfCorretor;
    }

    public String getCnpjCorretor() {
        return cnpjCorretor;
    }

    public void setCnpjCorretor(String cnpjCorretor) {
        this.cnpjCorretor = cnpjCorretor;
    }

    public LocalDateTime getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(LocalDateTime dataVenda) {
        this.dataVenda = dataVenda;
    }
}