package com.example.demo.DBEntities.Pessoa.Funcionario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.DBEntities.Pessoa.PessoaId;

public interface FuncionarioRepository extends JpaRepository<Funcionario, PessoaId> {
    
    @Query("""
        SELECT f
        FROM Funcionario f
        WHERE f.id.cpf LIKE CONCAT(:filtro, '%')
           OR f.id.cnpj LIKE CONCAT(:filtro, '%')
           OR LOWER(f.pessoa.nome) LIKE LOWER(CONCAT(:filtro, '%'))
           OR LOWER(f.tipoCargo) LIKE LOWER(CONCAT(:filtro, '%'))
    """)
    List<Funcionario> findByCpfOrCnpjOrNomeOrCargo(@Param("filtro") String filtro);

    @Query("""
        SELECT f
        FROM Funcionario f
        WHERE (f.id.cpf LIKE CONCAT(:filtro, '%')
           OR f.id.cnpj LIKE CONCAT(:filtro, '%'))
           AND LOWER(f.senha) = :senha
    """)
    List<Funcionario> findByCpfOrCnpjAndPassword(@Param("filtro") String filtro, @Param("senha") String senha);
}