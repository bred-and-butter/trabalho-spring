package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;

import com.example.demo.DBEntities.Pessoa.Pessoa;
import com.example.demo.DBEntities.Pessoa.PessoaId;
import com.example.demo.DBEntities.Pessoa.PessoaRepository;
import com.example.demo.DBEntities.Pessoa.Funcionario.Funcionario;
import com.example.demo.DBEntities.Pessoa.Funcionario.FuncionarioDTO;
import com.example.demo.DBEntities.Pessoa.Funcionario.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/users")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping
    public List<FuncionarioDTO> listarFuncionarios(@RequestParam(required = false) String search) {
        List<Funcionario> funcionarios;

        if (search != null && !search.isEmpty()) {
            funcionarios = funcionarioRepository.findByCpfOrCnpjOrNomeOrCargo(search);
        } else {
            funcionarios = funcionarioRepository.findAll();
        }

        return funcionarios.stream().map(FuncionarioDTO::new).toList();
    }
}