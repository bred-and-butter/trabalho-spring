package com.example.demo.controller;

import com.example.demo.DBEntities.Pessoa.Funcionario.Funcionario;
import com.example.demo.DBEntities.Pessoa.Funcionario.FuncionarioDTO;
import com.example.demo.DBEntities.Pessoa.Funcionario.FuncionarioRepository;
import com.example.demo.DBEntities.Pessoa.PessoaId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LoginController {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @PostMapping(value = "/api/auth/login")
    public ResponseEntity<Void> verificaLogin (@RequestBody FuncionarioDTO loginInfo) {
        String login = loginInfo.getCpf();
        String senha = loginInfo.getSenha();
        PessoaId pessoaId = null;

        if (login.length() == 11) {
            pessoaId = new PessoaId(login, "");
        } else if (login.length() == 14) {
            pessoaId = new PessoaId("", login);
        }

        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(pessoaId);
        List<Funcionario> funcionarioSenha = funcionarioRepository.findByCpfOrCnpjAndPassword(login, senha);

        if (funcionarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else if (funcionarioSenha.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
