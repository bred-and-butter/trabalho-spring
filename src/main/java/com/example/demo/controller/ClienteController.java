package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

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
import java.util.Optional;

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

        if (search != null && !search.isEmpty()) {
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
        pessoa.setComplemento(dto.getComplemento());
        pessoa.setNumero(dto.getNumero());

        PessoaId id = new PessoaId(dto.getCpf(), dto.getCnpj());
        pessoa.setId(id);

        pessoaRepository.save(pessoa);

        Cliente cliente = new Cliente();
        cliente.setId(id);
        cliente.setPessoa(pessoa);
        cliente.setDataCadastro(LocalDate.now());

        clienteRepository.save(cliente);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ClienteDTO(cliente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable String id) {
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

        return clienteRepository.findById(new PessoaId(cpf, cnpj))
                .map(cliente -> ResponseEntity.ok(new ClienteDTO(cliente)))
                .orElse(ResponseEntity.notFound().build()); // 404 sem corpo
    }

    @PutMapping("/{id}")
    public ResponseEntity<List<ClienteDTO>> atualizarCliente(
            @PathVariable String id,
            @RequestBody ClienteDTO dto) {

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
        Optional<Cliente> clienteOpt = clienteRepository.findById(pessoaId);

        if (clienteOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        // Atualiza os dados da pessoa
        Cliente cliente = clienteOpt.get();
        Pessoa pessoa = cliente.getPessoa();

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
        clienteRepository.save(cliente);

        // Retorna lista atualizada para o front recarregar a tabela
        List<ClienteDTO> listaAtualizada = clienteRepository.findAll()
                .stream()
                .map(ClienteDTO::new)
                .toList();

        return ResponseEntity.ok(listaAtualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCliente(@PathVariable String id) {
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

        if (!clienteRepository.existsById(pessoaId)) {
            return ResponseEntity.notFound().build();
        }

        clienteRepository.deleteById(pessoaId);
        pessoaRepository.deleteById(pessoaId); // se quiser deletar também da tabela pessoa

        return ResponseEntity.noContent().build(); // 204 sem corpo
    }
}