package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.DBEntities.Imovel.ImovelDTO;
import com.example.demo.DBEntities.Imovel.ImovelRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/properties")
public class ImovelController {

    @Autowired
    private ImovelRepository imovelRepository;

    @GetMapping
public List<ImovelDTO> listarImoveis(@RequestParam(required = false) String search) {
    List<Object[]> resultados;

    if (search != null && !search.isEmpty()) {
        resultados = imovelRepository.findAllWithTipoInfoFiltrada(search);
    } else {
        resultados = imovelRepository.findAllWithTipoInfo();
    }

    return resultados.stream().map(row -> {
        ImovelDTO dto = new ImovelDTO();
        dto.setNumeroMatriculaImovel((String) row[0]);
        dto.setEndereco((String) row[1]);
        dto.setBairro((String) row[2]);
        dto.setCidade((String) row[3]);
        dto.setEstado((String) row[4]);
        dto.setValor((BigDecimal) row[5]);
        dto.setStatus((String) row[6]);
        dto.setDataCadastro(row[7].toString());
        dto.setNomeProprietario((String) row[8]);
        dto.setFinalidade((String) row[9]);
        return dto;
    }).collect(Collectors.toList());
}
}