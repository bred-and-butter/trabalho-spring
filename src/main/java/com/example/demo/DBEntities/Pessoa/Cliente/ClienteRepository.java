package com.example.demo.DBEntities.Pessoa.Cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DBEntities.Pessoa.PessoaId;

public interface ClienteRepository extends JpaRepository<Cliente, PessoaId> {
        @Query("""
        SELECT c 
        FROM Cliente c 
        WHERE c.id.cpf LIKE CONCAT(:doc, '%') 
        OR c.id.cnpj LIKE CONCAT(:doc, '%') 
        OR LOWER(c.pessoa.nome) LIKE LOWER(CONCAT(:doc, '%'))
        """)
        List<Cliente> findByCpfOrCnpjOrNome(@Param("doc") String doc);
}