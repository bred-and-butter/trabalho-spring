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
import com.example.demo.DBEntities.Pessoa.Cliente.Cliente;
import com.example.demo.DBEntities.Pessoa.Cliente.ClienteDTO;
import com.example.demo.DBEntities.Pessoa.Cliente.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api/clients")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<ClienteDTO> listarClientes(@RequestParam(required = false) String search) {
        List<Cliente> clientes;

        if (!search.isEmpty()) {
            clientes = clienteRepository.findByCpfOrCnpjOrNome(search);
        } else {
            clientes = clienteRepository.findAll();
        }
        return clientes.stream().map(ClienteDTO::new).toList();
    }

    @PostMapping
    public ResponseEntity<ClienteDTO> criarCliente(@RequestBody ClienteDTO dto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(dto.getNome());
        pessoa.setEmail(dto.getEmail());
        pessoa.setTelefone(dto.getTelefone());
        pessoa.setEndereco(dto.getEndereco());
        pessoa.setBairro(dto.getBairro());
        pessoa.setCidade(dto.getCidade());
        pessoa.setEstado(dto.getEstado());
        pessoa.setCep(dto.getCep());

        PessoaId id = new PessoaId(dto.getCpf(), dto.getCnpj());
        pessoa.setId(id);

        pessoaRepository.save(pessoa);

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setPessoa(pessoa);
        cliente.setDataCadastro(LocalDate.now());

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteDTO(cliente));
    }
}