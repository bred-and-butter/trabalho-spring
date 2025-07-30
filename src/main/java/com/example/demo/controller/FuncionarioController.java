package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import com.example.demo.DBEntities.Pessoa.Pessoa;
import com.example.demo.DBEntities.Pessoa.PessoaId;
import com.example.demo.DBEntities.Pessoa.PessoaRepository;
import com.example.demo.DBEntities.Pessoa.Funcionario.Funcionario;
import com.example.demo.DBEntities.Pessoa.Funcionario.FuncionarioDTO;
import com.example.demo.DBEntities.Pessoa.Funcionario.FuncionarioRepository;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
public class FuncionarioController {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

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

    @PostMapping
    public ResponseEntity<FuncionarioDTO> criarFuncionario(@RequestBody FuncionarioDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEndereco(dto.getEndereco());
        pessoa.setBairro(dto.getBairro());
        pessoa.setCidade(dto.getCidade());
        pessoa.setEstado(dto.getEstado());
        pessoa.setCep(dto.getCep());
        pessoa.setComplemento(dto.getComplemento());
        pessoa.setNumero(dto.getNumero());

        PessoaId id = new PessoaId(dto.getCpf(), dto.getCnpj());
        pessoa.setId(id);

        pessoaRepository.save(pessoa);

        Funcionario funcionario = new Funcionario();
        funcionario.setId(id);
        funcionario.setPessoa(pessoa);
        funcionario.setTipoCargo(dto.getTipoCargo());
        funcionario.setAreaAtuacao(dto.getAreaAtuacao());
        funcionario.setAtivo(dto.getAtivo());

        funcionarioRepository.save(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(new FuncionarioDTO(funcionario));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTO> buscarFuncionarioPorId(@PathVariable String id) {
        String cpf = "";
        String cnpj = "";


        if (id.toLowerCase().startsWith("cpf")) {
            cpf = id.substring(3); // remove "cpf"
        } else if (id.toLowerCase().startsWith("cnpj")) {
            cnpj = id.substring(4); // remove "cnpj"
            // Insere barra depois do 8º caractere

            cnpj = cnpj.substring(0, 10) + "/" + cnpj.substring(10);

        } else {
            return ResponseEntity.badRequest().build(); // formato inválido
        }

        return funcionarioRepository.findById(new PessoaId(cpf, cnpj))
                .map(funcionario -> ResponseEntity.ok(new FuncionarioDTO(funcionario)))
                .orElse(ResponseEntity.notFound().build()); // 404 sem corpo
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<FuncionarioDTO>> atualizarCliente(
            @PathVariable String id,
            @RequestBody FuncionarioDTO dto) {

        String cpf = "";
        String cnpj = "";


        if (id.toLowerCase().startsWith("cpf")) {
            cpf = id.substring(3); // remove "cpf"
        } else if (id.toLowerCase().startsWith("cnpj")) {
            cnpj = id.substring(4); // remove "cnpj"
            // Insere barra depois do 8º caractere

            cnpj = cnpj.substring(0, 10) + "/" + cnpj.substring(10);

        } else {
            return ResponseEntity.badRequest().build(); // formato inválido
        }

        PessoaId pessoaId = new PessoaId(cpf, cnpj);
        Optional<Funcionario> funcionarioOpt = funcionarioRepository.findById(pessoaId);

        if (funcionarioOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Atualiza os dados da pessoa
        Funcionario funcionario = funcionarioOpt.get();
        Pessoa pessoa = funcionario.getPessoa();

        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEndereco(dto.getEndereco());
        pessoa.setBairro(dto.getBairro());
        pessoa.setCidade(dto.getCidade());
        pessoa.setEstado(dto.getEstado());
        pessoa.setCep(dto.getCep());
        pessoa.setComplemento(dto.getComplemento());
        pessoa.setNumero(dto.getNumero());

        pessoaRepository.save(pessoa);

        // Cliente geralmente só tem data de cadastro, mas se precisar atualiza
        funcionarioRepository.save(funcionario);

        // Retorna lista atualizada para o front recarregar a tabela
        List<FuncionarioDTO> listaAtualizada = funcionarioRepository.findAll()
                .stream()
                .map(FuncionarioDTO::new)
                .toList();

        return ResponseEntity.ok(listaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable String id) {
        if (id == null || id.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        String cpf = "";
        String cnpj = "";


        if (id.toLowerCase().startsWith("cpf")) {
            cpf = id.substring(3); // remove "cpf"
        } else if (id.toLowerCase().startsWith("cnpj")) {
            cnpj = id.substring(4); // remove "cnpj"
            // Insere barra depois do 8º caractere

            cnpj = cnpj.substring(0, 10) + "/" + cnpj.substring(10);

        } else {
            return ResponseEntity.badRequest().build(); // formato inválido
        }

        PessoaId pessoaId = new PessoaId(cpf, cnpj);

        if (!funcionarioRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }

        funcionarioRepository.deleteById(pessoaId);
        pessoaRepository.deleteById(pessoaId); // se quiser deletar também da tabela pessoa

        return ResponseEntity.noContent().build(); // 204 sem corpo
    }
}