package com.example.demo.DBEntities.Pessoa.Cliente;

import jakarta.persistence.*;
import java.time.LocalDate;

import com.example.demo.DBEntities.Pessoa.Pessoa;
import com.example.demo.DBEntities.Pessoa.PessoaId;

@Entity
public class Cliente {

    @EmbeddedId
    private PessoaId id;

    @MapsId
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "cpf_cliente", referencedColumnName = "cpf"),
        @JoinColumn(name = "cnpj_cliente", referencedColumnName = "cnpj")
    })
    private Pessoa pessoa;

    @Column(name = "data_cadastro", nullable = false)
    private LocalDate dataCadastro;

    public PessoaId getId() {
        return id;
    }

    public void setId(PessoaId id) {
        this.id = id;
    }

    public String getCpf(){
        return id.getCpf();
    }

    public String getCnpj(){
        return id.getCnpj();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa){
        this.pessoa = pessoa;
    }

    public void setDataCadastro(LocalDate dataCadastro){
        this.dataCadastro = dataCadastro;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public String getDocumentType(){
        return id.getDocumentType();
    }
}
