package com.example.demo.DBEntities.Pessoa.Cliente;

public class ClienteDTO {

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
    private String dataCadastro;

    public ClienteDTO() {
    }

    public ClienteDTO(Cliente cliente) {
        this.nome = cliente.getPessoa().getNome();
        this.email = cliente.getPessoa().getEmail();
        this.telefone = cliente.getPessoa().getTelefone();
        this.documentType = cliente.getDocumentType();
        this.cpf = cliente.getCpf();
        this.cnpj = cliente.getCnpj();
        this.endereco = cliente.getPessoa().getEndereco();
        this.bairro = cliente.getPessoa().getBairro();
        this.cidade = cliente.getPessoa().getCidade();
        this.complemento = cliente.getPessoa().getComplemento();
        this.estado = cliente.getPessoa().getEstado();
        this.cep = cliente.getPessoa().getCep();
        this.dataCadastro = cliente.getDataCadastro().toString();
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

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
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
}