package com.example.demo.DBEntities.Person;

import jakarta.persistence.*;

@Entity
@IdClass(CPFCNPJId.class)
@Table(name = "person")
public class Person {
    @Id
    private String cpf;
    @Id
    private String cnpj;

    @Column(nullable = false)
    private String nome;
    private String email;
    private String telefone;
    private String endereco;

    public String getCpf() {return cpf;}
    public void setCpf(String cpf) {this.cpf = cpf;}

    public String getCnpj() {return cnpj;}
    public void setCnpj(String cnpj) {this.cnpj = cnpj;}

    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getTelefone() {return telefone;}
    public void setEndereco(String endereco) {this.endereco = endereco;}

    public String getEndereco() {return endereco;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
