package com.example.demo.DBEntities.Pessoa;

import jakarta.persistence.*;

@Entity
public class Pessoa {

    @EmbeddedId
    private PessoaId id;

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(length = 255)
    private String email;
    @Column(length = 255)
    private String telefone;
    @Column(length = 255)
    private String endereco;
    @Column(length = 100)
    private String bairro;
    @Column(length = 100)
    private String complemento;
    @Column(length = 100)
    private String cidade;
    @Column(length = 2)
    private String estado;
    @Column(length = 10)
    private String cep;
    @Column(length = 10)
    private String numero;

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

    public String getDocumentType(){
        return id.getDocumentType();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

     public void setNumero(String numero) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }
}