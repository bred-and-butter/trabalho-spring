package com.example.demo.DBEntities.Pessoa.Funcionario;

import jakarta.persistence.*;
import java.io.Serializable;

import com.example.demo.DBEntities.Pessoa.Pessoa;
import com.example.demo.DBEntities.Pessoa.PessoaId;

@Entity
public class Funcionario implements Serializable {

    @EmbeddedId
    private PessoaId id;

    @MapsId
    @OneToOne
    @JoinColumns({
        @JoinColumn(name = "cpf_funcionario", referencedColumnName = "cpf"),
        @JoinColumn(name = "cnpj_funcionario", referencedColumnName = "cnpj")
    })
    private Pessoa pessoa;

    @Column(name = "tipo_cargo", nullable = false, length = 50)
    private String tipoCargo;

    @Column(name = "area_atuacao", length = 255)
    private String areaAtuacao;

    @Column(name = "senha", nullable = false, length = 255)
    private String senha;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo = true;

    public PessoaId getId() {
        return id;
    }

    public void setId(PessoaId id) {
        this.id = id;
    }

    public String getCpf() {
        return id.getCpf();
    }

    public String getCnpj() {
        return id.getCnpj();
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getAreaAtuacao() {
        return areaAtuacao;
    }

    public void setAreaAtuacao(String areaAtuacao) {
        this.areaAtuacao = areaAtuacao;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getDocumentType() {
        return id.getDocumentType();
    }
}