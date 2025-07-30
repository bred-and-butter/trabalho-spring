package com.example.demo.DBEntities.Pessoa.Funcionario;

public class FuncionarioDTO {

    private String nome;
    private String cpf;
    private String cnpj;
    private String documentType;
    private String email;
    private String telefone;
    private String endereco;
    private String bairro;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;
    private String tipoCargo;
    private String areaAtuacao;
    private String numero;
    private String senha;
    private Boolean ativo;

    public FuncionarioDTO() {
    }

    public FuncionarioDTO(Funcionario funcionario) {
        this.nome = funcionario.getPessoa().getNome();
        this.email = funcionario.getPessoa().getEmail();
        this.telefone = funcionario.getPessoa().getTelefone();
        this.documentType = funcionario.getDocumentType();
        this.cpf = funcionario.getCpf();
        this.cnpj = funcionario.getCnpj();
        this.endereco = funcionario.getPessoa().getEndereco();
        this.bairro = funcionario.getPessoa().getBairro();
        this.cidade = funcionario.getPessoa().getCidade();
        this.complemento = funcionario.getPessoa().getComplemento();
        this.estado = funcionario.getPessoa().getEstado();
        this.cep = funcionario.getPessoa().getCep();
        this.tipoCargo = funcionario.getTipoCargo();
        this.areaAtuacao = funcionario.getAreaAtuacao();
        this.ativo = funcionario.getAtivo();
        this.numero = funcionario.getPessoa().getNumero();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
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

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
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

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

     public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }
}