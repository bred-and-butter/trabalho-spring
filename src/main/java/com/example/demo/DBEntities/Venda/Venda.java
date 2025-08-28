package com.example.demo.DBEntities.Venda;

import jakarta.persistence.*;
import com.example.demo.DBEntities.Pessoa.Cliente.Cliente;
import com.example.demo.DBEntities.Pessoa.Funcionario.Funcionario;
import com.example.demo.DBEntities.Imovel.Imovel;
import com.example.demo.DBEntities.Venda.VendaId;
import java.math.BigDecimal;

@Entity
@Table(name = "VENDA")
public class Venda {

    @EmbeddedId
    private VendaId id;

    @ManyToOne
    @MapsId("numeroMatriculaImovel")
    @JoinColumn(name = "numero_matricula_imovel", nullable = false, insertable=false, updatable=false)
    private Imovel imovel;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cpf_cliente_comprador", referencedColumnName = "cpf_cliente", insertable=false, updatable=false),
            @JoinColumn(name = "cnpj_cliente_comprador", referencedColumnName = "cnpj_cliente", insertable=false, updatable=false)
    })
    private Cliente comprador;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cpf_proprietario_imovel", referencedColumnName = "cpf_cliente", insertable=false, updatable=false),
            @JoinColumn(name = "cnpj_proprietario_imovel", referencedColumnName = "cnpj_cliente", insertable=false, updatable=false)
    })
    private Cliente proprietario;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "cpf_corretor", referencedColumnName = "cpf_funcionario", insertable=false, updatable=false),
            @JoinColumn(name = "cnpj_corretor", referencedColumnName = "cnpj_funcionario", insertable=false, updatable=false)
    })
    private Funcionario corretor;

    @Column(name = "valor_final", nullable = false, precision = 15, scale = 2)
    private BigDecimal valorFinal;

    public Venda() {}

    // getters e setters
    public VendaId getId() {
        return id;
    }

    public void setId(VendaId id) {
        this.id = id;
    }

    public Imovel getImovel() {
        return imovel;
    }

    public void setImovel(Imovel imovel) {
        this.imovel = imovel;
    }

    public Cliente getComprador() {
        return comprador;
    }

    public void setComprador(Cliente comprador) {
        this.comprador = comprador;
    }

    public Cliente getProprietario() {
        return proprietario;
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public Funcionario getCorretor() {
        return corretor;
    }

    public void setCorretor(Funcionario corretor) {
        this.corretor = corretor;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }
}
