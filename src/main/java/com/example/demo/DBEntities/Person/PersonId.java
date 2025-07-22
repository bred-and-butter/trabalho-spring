package com.example.demo.DBEntities.Person;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PersonId implements Serializable {
    private String cpf;
    private String cnpj;

    public PersonId(String cpf, String cnpj) {
        this.cpf = cpf;
        this.cnpj = cnpj;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonId productId = (PersonId) o;
        return Objects.equals(cpf, productId.cpf) &&
                Objects.equals(cnpj, productId.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, cnpj);
    }
}
