package com.example.demo.DBEntities.Pessoa;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PessoaId implements Serializable {

    @Column(length = 14)
    private String cpf = "";
    @Column(length = 18)
    private String cnpj = "";

    public PessoaId(){};

    public PessoaId(String cpf, String cnpj) {
        if (cpf.equals("null")){
            cpf = "";
        }
        if (cnpj.equals("null")){
            cnpj = "";
        }

        if ((!cpf.equals("") && cnpj.equals("")) ||
            (cpf.equals("") && !cnpj.equals(""))) {
            this.cpf = cpf;
            this.cnpj = cnpj;
        } else {
            throw new IllegalArgumentException("CPF ou CPNG devem ser preenchidos, mas não ambos.");
        }
    }

    public String getCpf(){
        return cpf;
    }

    public String getCnpj(){
        return cnpj;
    }

    public String getDocumentType(){
        if(cpf.equals("")){
            return "CNPJ";
        }
        else{
            return "CPF";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PessoaId)) return false;
        PessoaId that = (PessoaId) o;
        return cpf.equals(that.cpf) && cnpj.equals(that.cnpj);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf, cnpj);
    }
}