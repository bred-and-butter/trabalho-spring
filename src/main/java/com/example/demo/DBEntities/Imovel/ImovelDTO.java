package com.example.demo.DBEntities.Imovel;

import java.math.BigDecimal;

public class ImovelDTO {

    // Campos da tabela IMOVEL
    private String numeroMatriculaImovel;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String cep;
    private BigDecimal areaTotal;
    private BigDecimal valor;
    private String status;
    private String dataCadastro;
    private String dataAtualizacao;
    private String nomeProprietario;
    private String cpfProprietario;
    private String cnpjProprietario;
    private String finalidade;

    // Campos da tabela TERRENO
    private String topografia;
    private String tipoSolo;

    // Campos da tabela UNIDADE_RESIDENCIAL
    private Integer numeroQuartos;
    private Integer numeroBanheiros;
    private Integer numeroSuites;
    private BigDecimal areaConstruida;
    private Integer numeroVagasGaragem;
    private String descricao; // pode ser usada para residencial e comercial

    // Campos da tabela CASA
    private Boolean possuiQuintal;
    private Integer numeroPavimentos;

    // Campos da tabela APARTAMENTO
    private Integer andar; // pode ser usado para sala comercial também
    private String numeroApartamento;
    private Boolean possuiElevador;

    // Campos da tabela UNIDADE_COMERCIAL
    private BigDecimal areaUtil;

    // Campos da tabela PREDIO_COMERCIAL
    private Integer totalAndares;
    private Integer numeroSalas;
    private Boolean possuiEstacionamento;

    // Campos da tabela SALA_COMERCIAL
    private String numeroSala;

    private String tipoImovel;

    public ImovelDTO() {
    }

    public String getNumeroMatriculaImovel() { return numeroMatriculaImovel; }
    public void setNumeroMatriculaImovel(String numeroMatriculaImovel) { this.numeroMatriculaImovel = numeroMatriculaImovel; }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getBairro() { return bairro; }
    public void setBairro(String bairro) { this.bairro = bairro; }

    public String getCidade() { return cidade; }
    public void setCidade(String cidade) { this.cidade = cidade; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public String getCep() { return cep; }
    public void setCep(String cep) { this.cep = cep; }

    public BigDecimal getAreaTotal() { return areaTotal; }
    public void setAreaTotal(BigDecimal areaTotal) { this.areaTotal = areaTotal; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getDataCadastro() { return dataCadastro; }
    public void setDataCadastro(String dataCadastro) { this.dataCadastro = dataCadastro; }

    public String getDataAtualizacao() { return dataAtualizacao; }
    public void setDataAtualizacao(String dataAtualizacao) { this.dataAtualizacao = dataAtualizacao; }

    public String getNomeProprietario() { return nomeProprietario; }
    public void setNomeProprietario(String nomeProprietario) { this.nomeProprietario = nomeProprietario; }

    public String getCpfProprietario() { return cpfProprietario; }
    public void setCpfProprietario(String cpfProprietario) { this.cpfProprietario = cpfProprietario; }

    public String getCnpjProprietario() { return cnpjProprietario; }
    public void setCnpjProprietario(String cnpjProprietario) { this.cnpjProprietario = cnpjProprietario; }

    public String getFinalidade() { return finalidade; }
    public void setFinalidade(String finalidade) { this.finalidade = finalidade; }

    public String getTopografia() { return topografia; }
    public void setTopografia(String topografia) { this.topografia = topografia; }

    public String getTipoSolo() { return tipoSolo; }
    public void setTipoSolo(String tipoSolo) { this.tipoSolo = tipoSolo; }

    public Integer getNumeroQuartos() { return numeroQuartos; }
    public void setNumeroQuartos(Integer numeroQuartos) { this.numeroQuartos = numeroQuartos; }

    public Integer getNumeroBanheiros() { return numeroBanheiros; }
    public void setNumeroBanheiros(Integer numeroBanheiros) { this.numeroBanheiros = numeroBanheiros; }

    public Integer getNumeroSuites() { return numeroSuites; }
    public void setNumeroSuites(Integer numeroSuites) { this.numeroSuites = numeroSuites; }

    public BigDecimal getAreaConstruida() { return areaConstruida; }
    public void setAreaConstruida(BigDecimal areaConstruida) { this.areaConstruida = areaConstruida; }

    public Integer getNumeroVagasGaragem() { return numeroVagasGaragem; }
    public void setNumeroVagasGaragem(Integer numeroVagasGaragem) { this.numeroVagasGaragem = numeroVagasGaragem; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public Boolean getPossuiQuintal() { return possuiQuintal; }
    public void setPossuiQuintal(Boolean possuiQuintal) { this.possuiQuintal = possuiQuintal; }

    public Integer getNumeroPavimentos() { return numeroPavimentos; }
    public void setNumeroPavimentos(Integer numeroPavimentos) { this.numeroPavimentos = numeroPavimentos; }

    public Integer getAndar() { return andar; }
    public void setAndar(Integer andar) { this.andar = andar; }

    public String getNumeroApartamento() { return numeroApartamento; }
    public void setNumeroApartamento(String numeroApartamento) { this.numeroApartamento = numeroApartamento; }

    public Boolean getPossuiElevador() { return possuiElevador; }
    public void setPossuiElevador(Boolean possuiElevador) { this.possuiElevador = possuiElevador; }

    public BigDecimal getAreaUtil() { return areaUtil; }
    public void setAreaUtil(BigDecimal areaUtil) { this.areaUtil = areaUtil; }

    public Integer getTotalAndares() { return totalAndares; }
    public void setTotalAndares(Integer totalAndares) { this.totalAndares = totalAndares; }

    public Integer getNumeroSalas() { return numeroSalas; }
    public void setNumeroSalas(Integer numeroSalas) { this.numeroSalas = numeroSalas; }

    public Boolean getPossuiEstacionamento() { return possuiEstacionamento; }
    public void setPossuiEstacionamento(Boolean possuiEstacionamento) { this.possuiEstacionamento = possuiEstacionamento; }

    public String getNumeroSala() { return numeroSala; }
    public void setNumeroSala(String numeroSala) { this.numeroSala = numeroSala; }

    public String getTipoImovel() { return tipoImovel; }
    public void setTipoImovel(String tipoImovel) { this.tipoImovel = tipoImovel; }
}