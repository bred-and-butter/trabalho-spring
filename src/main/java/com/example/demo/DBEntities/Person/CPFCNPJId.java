package com.example.demo.DBEntities.Person;

import java.io.Serializable;

public class CPFCNPJId implements Serializable {
    private String cpf;
    private String cnpj;

    public CPFCNPJId () {}

    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnpj() {
        return cnpj;
    }
    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
