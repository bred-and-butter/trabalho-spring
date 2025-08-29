package com.example.demo.DBEntities.Imovel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ImovelRepository extends JpaRepository<Imovel, String> {

    @Query(value = """
    SELECT 
    i.numero_matricula_imovel,
    i.endereco,
    i.bairro,
    i.cidade,
    i.estado,
    i.valor,
    i.status,
    i.data_cadastro,

    p.nome AS nome_proprietario,

    CASE 
        WHEN t.numero_matricula_imovel IS NOT NULL THEN 'TERRENO'
        WHEN c.numero_matricula_imovel IS NOT NULL THEN 'CASA'
        WHEN a.numero_matricula_imovel IS NOT NULL THEN 'APARTAMENTO'
        WHEN pc.numero_matricula_imovel IS NOT NULL THEN 'PREDIO_COMERCIAL'
        WHEN sc.numero_matricula_imovel IS NOT NULL THEN 'SALA_COMERCIAL'
        WHEN ur.numero_matricula_imovel IS NOT NULL THEN 'UNIDADE_RESIDENCIAL'
        WHEN uc.numero_matricula_imovel IS NOT NULL THEN 'UNIDADE_COMERCIAL'
        ELSE 'DESCONHECIDO'
    END AS finalidade

FROM imovel i

JOIN cliente cte ON cte.cpf_cliente = i.cpf_proprietario AND cte.cnpj_cliente = i.cnpj_proprietario
JOIN pessoa p ON p.cpf = cte.cpf_cliente AND p.cnpj = cte.cnpj_cliente

LEFT JOIN terreno t ON i.numero_matricula_imovel = t.numero_matricula_imovel
LEFT JOIN unidade_residencial ur ON i.numero_matricula_imovel = ur.numero_matricula_imovel
LEFT JOIN casa c ON ur.numero_matricula_imovel = c.numero_matricula_imovel
LEFT JOIN apartamento a ON ur.numero_matricula_imovel = a.numero_matricula_imovel
LEFT JOIN unidade_comercial uc ON i.numero_matricula_imovel = uc.numero_matricula_imovel
LEFT JOIN predio_comercial pc ON uc.numero_matricula_imovel = pc.numero_matricula_imovel
LEFT JOIN sala_comercial sc ON uc.numero_matricula_imovel = sc.numero_matricula_imovel;
    """, nativeQuery = true)
    List<Object[]> findAllWithTipoInfo();

    @Query(value = """
    SELECT 
        i.numero_matricula_imovel,
        i.endereco,
        i.bairro,
        i.cidade,
        i.estado,
        i.valor,
        i.status,
        i.data_cadastro,

        p.nome AS nome_proprietario,

        CASE 
            WHEN t.numero_matricula_imovel IS NOT NULL THEN 'TERRENO'
            WHEN c.numero_matricula_imovel IS NOT NULL THEN 'CASA'
            WHEN a.numero_matricula_imovel IS NOT NULL THEN 'APARTAMENTO'
            WHEN pc.numero_matricula_imovel IS NOT NULL THEN 'PREDIO_COMERCIAL'
            WHEN sc.numero_matricula_imovel IS NOT NULL THEN 'SALA_COMERCIAL'
            WHEN ur.numero_matricula_imovel IS NOT NULL THEN 'UNIDADE_RESIDENCIAL'
            WHEN uc.numero_matricula_imovel IS NOT NULL THEN 'UNIDADE_COMERCIAL'
            ELSE 'DESCONHECIDO'
        END AS finalidade

    FROM imovel i

    JOIN cliente cte ON cte.cpf_cliente = i.cpf_proprietario AND cte.cnpj_cliente = i.cnpj_proprietario
    JOIN pessoa p ON p.cpf = cte.cpf_cliente AND p.cnpj = cte.cnpj_cliente

    LEFT JOIN terreno t ON i.numero_matricula_imovel = t.numero_matricula_imovel
    LEFT JOIN unidade_residencial ur ON i.numero_matricula_imovel = ur.numero_matricula_imovel
    LEFT JOIN casa c ON ur.numero_matricula_imovel = c.numero_matricula_imovel
    LEFT JOIN apartamento a ON ur.numero_matricula_imovel = a.numero_matricula_imovel
    LEFT JOIN unidade_comercial uc ON i.numero_matricula_imovel = uc.numero_matricula_imovel
    LEFT JOIN predio_comercial pc ON uc.numero_matricula_imovel = pc.numero_matricula_imovel
    LEFT JOIN sala_comercial sc ON uc.numero_matricula_imovel = sc.numero_matricula_imovel

    WHERE 
        LOWER(i.endereco) LIKE LOWER(CONCAT('%', :filtro, '%')) OR
        LOWER(i.numero_matricula_imovel) LIKE LOWER(CONCAT('%', :filtro, '%')) OR
        LOWER(
            CASE 
                WHEN t.numero_matricula_imovel IS NOT NULL THEN 'TERRENO'
                WHEN c.numero_matricula_imovel IS NOT NULL THEN 'CASA'
                WHEN a.numero_matricula_imovel IS NOT NULL THEN 'APARTAMENTO'
                WHEN pc.numero_matricula_imovel IS NOT NULL THEN 'PREDIO_COMERCIAL'
                WHEN sc.numero_matricula_imovel IS NOT NULL THEN 'SALA_COMERCIAL'
                WHEN ur.numero_matricula_imovel IS NOT NULL THEN 'UNIDADE_RESIDENCIAL'
                WHEN uc.numero_matricula_imovel IS NOT NULL THEN 'UNIDADE_COMERCIAL'
                ELSE 'DESCONHECIDO'
            END
        ) LIKE LOWER(CONCAT('%', :filtro, '%'))
    """, nativeQuery = true)
    List<Object[]> findAllWithTipoInfoFiltrada(@Param("filtro") String filtro);
}