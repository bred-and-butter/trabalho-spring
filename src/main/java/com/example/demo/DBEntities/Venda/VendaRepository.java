package com.example.demo.DBEntities.Venda;

import com.example.demo.DBEntities.Venda.Venda;
import com.example.demo.DBEntities.Venda.VendaId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendaRepository extends JpaRepository<Venda, VendaId> {

}
