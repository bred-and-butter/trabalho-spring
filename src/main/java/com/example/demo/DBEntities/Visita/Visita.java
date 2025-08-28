package com.example.demo.DBEntities.Visita;

import com.example.demo.DBEntities.Pessoa.*;
import com.example.demo.DBEntities.Pessoa.Cliente.Cliente;
import com.example.demo.DBEntities.Pessoa.Funcionario.Funcionario;
import com.example.demo.DBEntities.Imovel.*;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "VISITA")
public class Visita {

    @EmbeddedId
    private VisitaId id;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="cpf_corretor", referencedColumnName="cpf_funcionario", insertable=false, updatable=false),
        @JoinColumn(name="cnpj_corretor", referencedColumnName="cnpj_funcionario", insertable=false, updatable=false)
    })
    private Funcionario corretor;

    @ManyToOne
    @JoinColumns({
        @JoinColumn(name="cpf_cliente", referencedColumnName="cpf_cliente", insertable=false, updatable=false),
        @JoinColumn(name="cnpj_cliente", referencedColumnName="cnpj_cliente", insertable=false, updatable=false)
    })
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="numero_matricula_imovel", referencedColumnName="numero_matricula_imovel", insertable=false, updatable=false)
    private Imovel imovel;

    public VisitaId getId() {
        return id;
    }

    public void setId(VisitaId id) {
        this.id = id;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public void setCorretor(Funcionario corretor) {
        this.corretor = corretor;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public void setInteresse(Interesse interesse) {
        this.interesse = interesse;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public Funcionario getCorretor() {
        return corretor;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public Interesse getInteresse() {
        return interesse;
    }

    @Column(columnDefinition = "TEXT")
    private String observacoes;

    @OneToOne(mappedBy = "visita", cascade = CascadeType.ALL)
    private Interesse interesse;

    
}
