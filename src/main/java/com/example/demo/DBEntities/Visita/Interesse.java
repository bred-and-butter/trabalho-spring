package com.example.demo.DBEntities.Visita;

import jakarta.persistence.*;
import java.time.LocalDate;
import com.example.demo.DBEntities.Pessoa.*;
import com.example.demo.DBEntities.Visita.Visita;
import com.example.demo.DBEntities.Imovel.*;

@Entity
@Table(name = "INTERESSE")
public class Interesse {

     @EmbeddedId
    @AttributeOverrides({
        @AttributeOverride(name = "cpfCliente", column = @Column(name = "cpf_cliente")),
        @AttributeOverride(name = "cnpjCliente", column = @Column(name = "cnpj_cliente")),
        @AttributeOverride(name = "numeroMatriculaImovel", column = @Column(name = "numero_matricula_imovel")),
        @AttributeOverride(name = "cpfCorretor", column = @Column(name = "cpf_corretor")),
        @AttributeOverride(name = "cnpjCorretor", column = @Column(name = "cnpj_corretor")),
        @AttributeOverride(name = "dataHora", column = @Column(name = "data_hora_visita"))
    })
    private VisitaId id;

    @OneToOne
    @MapsId
    @JoinColumns({
        @JoinColumn(name = "cpf_cliente", referencedColumnName = "cpf_cliente"),
        @JoinColumn(name = "cnpj_cliente", referencedColumnName = "cnpj_cliente"),
        @JoinColumn(name = "numero_matricula_imovel", referencedColumnName = "numero_matricula_imovel"),
        @JoinColumn(name = "cpf_corretor", referencedColumnName = "cpf_corretor"),
        @JoinColumn(name = "cnpj_corretor", referencedColumnName = "cnpj_corretor"),
        @JoinColumn(name = "data_hora_visita", referencedColumnName = "data_hora")
    })
    private Visita visita;

    @Column(name = "data_registro", nullable = false)
    private LocalDate dataRegistro;

    @Column(name = "avaliacao_bairro")
    private Integer avaliacaoBairro;

    @Column(name = "avaliacao_cidade")
    private Integer avaliacaoCidade;

    @Column(name = "avaliacao_estado")
    private Integer avaliacaoEstado;

    @Column(name = "avaliacao_area_total")
    private Integer avaliacaoAreaTotal;

    @Column(name = "avaliacao_valor")
    private Integer avaliacaoValor;

    @Column(name = "avaliacao_topografia")
    private Integer avaliacaoTopografia;

    @Column(name = "avaliacao_tipo_solo")
    private Integer avaliacaoTipoSolo;

    @Column(name = "avaliacao_quartos")
    private Integer avaliacaoQuartos;

    @Column(name = "avaliacao_banheiros")
    private Integer avaliacaoBanheiros;

    @Column(name = "avaliacao_suites")
    private Integer avaliacaoSuites;

    @Column(name = "avaliacao_construida")
    private Integer avaliacaoConstruida;

    @Column(name = "avaliacao_garagem")
    private Integer avaliacaoGaragem;

    @Column(name = "avaliacao_quintal")
    private Integer avaliacaoQuintal;

    @Column(name = "avaliacao_numero_pavimentos")
    private Integer avaliacaoNumeroPavimentos;

    @Column(name = "avaliacao_andar_apartamento")
    private Integer avaliacaoAndarApartamento;

    @Column(name = "avaliacao_elevador")
    private Integer avaliacaoElevador;

    @Column(name = "avaliacao_area_util")
    private Integer avaliacaoAreaUtil;

    @Column(name = "avaliacao_total_andares")
    private Integer avaliacaoTotalAndares;

    @Column(name = "avaliacao_salas")
    private Integer avaliacaoSalas;

    @Column(name = "avaliacao_estacionamento")
    private Integer avaliacaoEstacionamento;

    @Column(name = "avaliacao_andar_sala")
    private Integer avaliacaoAndarSala;

    @Column(name = "avaliacao_sala")
    private Integer avaliacaoSala;

    public Interesse() {}

    // Getters e Setters

    public VisitaId getId() { return id; }
    public void setId(VisitaId id) { this.id = id; }

    public Visita getVisita() { return visita; }
    public void setVisita(Visita visita) { this.visita = visita; }

    public LocalDate getDataRegistro() { return dataRegistro; }
    public void setDataRegistro(LocalDate dataRegistro) { this.dataRegistro = dataRegistro; }

    public Integer getAvaliacaoBairro() { return avaliacaoBairro; }
    public void setAvaliacaoBairro(Integer avaliacaoBairro) { this.avaliacaoBairro = avaliacaoBairro; }

    public Integer getAvaliacaoCidade() { return avaliacaoCidade; }
    public void setAvaliacaoCidade(Integer avaliacaoCidade) { this.avaliacaoCidade = avaliacaoCidade; }

    public Integer getAvaliacaoEstado() { return avaliacaoEstado; }
    public void setAvaliacaoEstado(Integer avaliacaoEstado) { this.avaliacaoEstado = avaliacaoEstado; }

    public Integer getAvaliacaoAreaTotal() { return avaliacaoAreaTotal; }
    public void setAvaliacaoAreaTotal(Integer avaliacaoAreaTotal) { this.avaliacaoAreaTotal = avaliacaoAreaTotal; }

    public Integer getAvaliacaoValor() { return avaliacaoValor; }
    public void setAvaliacaoValor(Integer avaliacaoValor) { this.avaliacaoValor = avaliacaoValor; }

    public Integer getAvaliacaoTopografia() { return avaliacaoTopografia; }
    public void setAvaliacaoTopografia(Integer avaliacaoTopografia) { this.avaliacaoTopografia = avaliacaoTopografia; }

    public Integer getAvaliacaoTipoSolo() { return avaliacaoTipoSolo; }
    public void setAvaliacaoTipoSolo(Integer avaliacaoTipoSolo) { this.avaliacaoTipoSolo = avaliacaoTipoSolo; }

    public Integer getAvaliacaoQuartos() { return avaliacaoQuartos; }
    public void setAvaliacaoQuartos(Integer avaliacaoQuartos) { this.avaliacaoQuartos = avaliacaoQuartos; }

    public Integer getAvaliacaoBanheiros() { return avaliacaoBanheiros; }
    public void setAvaliacaoBanheiros(Integer avaliacaoBanheiros) { this.avaliacaoBanheiros = avaliacaoBanheiros; }

    public Integer getAvaliacaoSuites() { return avaliacaoSuites; }
    public void setAvaliacaoSuites(Integer avaliacaoSuites) { this.avaliacaoSuites = avaliacaoSuites; }

    public Integer getAvaliacaoConstruida() { return avaliacaoConstruida; }
    public void setAvaliacaoConstruida(Integer avaliacaoConstruida) { this.avaliacaoConstruida = avaliacaoConstruida; }

    public Integer getAvaliacaoGaragem() { return avaliacaoGaragem; }
    public void setAvaliacaoGaragem(Integer avaliacaoGaragem) { this.avaliacaoGaragem = avaliacaoGaragem; }

    public Integer getAvaliacaoQuintal() { return avaliacaoQuintal; }
    public void setAvaliacaoQuintal(Integer avaliacaoQuintal) { this.avaliacaoQuintal = avaliacaoQuintal; }

    public Integer getAvaliacaoNumeroPavimentos() { return avaliacaoNumeroPavimentos; }
    public void setAvaliacaoNumeroPavimentos(Integer avaliacaoNumeroPavimentos) { this.avaliacaoNumeroPavimentos = avaliacaoNumeroPavimentos; }

    public Integer getAvaliacaoAndarApartamento() { return avaliacaoAndarApartamento; }
    public void setAvaliacaoAndarApartamento(Integer avaliacaoAndarApartamento) { this.avaliacaoAndarApartamento = avaliacaoAndarApartamento; }

    public Integer getAvaliacaoElevador() { return avaliacaoElevador; }
    public void setAvaliacaoElevador(Integer avaliacaoElevador) { this.avaliacaoElevador = avaliacaoElevador; }

    public Integer getAvaliacaoAreaUtil() { return avaliacaoAreaUtil; }
    public void setAvaliacaoAreaUtil(Integer avaliacaoAreaUtil) { this.avaliacaoAreaUtil = avaliacaoAreaUtil; }

    public Integer getAvaliacaoTotalAndares() { return avaliacaoTotalAndares; }
    public void setAvaliacaoTotalAndares(Integer avaliacaoTotalAndares) { this.avaliacaoTotalAndares = avaliacaoTotalAndares; }

    public Integer getAvaliacaoSalas() { return avaliacaoSalas; }
    public void setAvaliacaoSalas(Integer avaliacaoSalas) { this.avaliacaoSalas = avaliacaoSalas; }

    public Integer getAvaliacaoEstacionamento() { return avaliacaoEstacionamento; }
    public void setAvaliacaoEstacionamento(Integer avaliacaoEstacionamento) { this.avaliacaoEstacionamento = avaliacaoEstacionamento; }

    public Integer getAvaliacaoAndarSala() { return avaliacaoAndarSala; }
    public void setAvaliacaoAndarSala(Integer avaliacaoAndarSala) { this.avaliacaoAndarSala = avaliacaoAndarSala; }

    public Integer getAvaliacaoSala() { return avaliacaoSala; }
    public void setAvaliacaoSala(Integer avaliacaoSala) { this.avaliacaoSala = avaliacaoSala; }
}