package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.repository.query.Param;

import com.example.demo.DBEntities.Pessoa.*;
import com.example.demo.DBEntities.Pessoa.Cliente.*; 
import com.example.demo.DBEntities.Imovel.*; 
import com.example.demo.DBEntities.Imovel.Terreno.*; 
import com.example.demo.DBEntities.Imovel.UnidadeComercial.*;
import com.example.demo.DBEntities.Imovel.UnidadeResidencial.*;  
import com.example.demo.DBEntities.Imovel.UnidadeComercial.PredioComercial.*; 
import com.example.demo.DBEntities.Imovel.UnidadeComercial.SalaComercial.*; 
import com.example.demo.DBEntities.Imovel.UnidadeResidencial.Apartamento.*; 
import com.example.demo.DBEntities.Imovel.UnidadeResidencial.Casa.*; 
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Optional;
import java.time.LocalDate;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/properties")
public class ImovelController {

    @Autowired
    private ImovelRepository imovelRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private TerrenoRepository terrenoRepository;
    @Autowired
    private UnidadeResidencialRepository unidadeResidencialRepository;
    @Autowired
    private CasaRepository casaRepository;
    @Autowired
    private ApartamentoRepository apartamentoRepository;
    @Autowired
    private UnidadeComercialRepository unidadeComercialRepository;
    @Autowired
    private PredioComercialRepository predioComercialRepository;
    @Autowired
    private SalaComercialRepository salaComercialRepository;

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

    @DeleteMapping("/{numeroMatricula}")
    public ResponseEntity<Void> deletarImovel(@PathVariable String numeroMatricula) {
        Optional<Imovel> imovelOpt = imovelRepository.findById(numeroMatricula);

        if (imovelOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        imovelRepository.delete(imovelOpt.get());
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ImovelDTO> criarImovel(@RequestBody ImovelDTO dto) {
        // Busca o cliente proprietário pelo CPF/CNPJ
        PessoaId pessoaId = new PessoaId(dto.getCpfProprietario(), dto.getCnpjProprietario());
        Optional<Cliente> clienteOpt = clienteRepository.findById(pessoaId);
        if (clienteOpt.isEmpty()) return ResponseEntity.badRequest().build();

        // cria base
        Imovel imovel = new Imovel();
        imovel.setNumeroMatriculaImovel(dto.getNumeroMatriculaImovel());
        imovel.setEndereco(dto.getEndereco());
        imovel.setBairro(dto.getBairro());
        imovel.setCidade(dto.getCidade());
        imovel.setEstado(dto.getEstado());
        imovel.setCep(dto.getCep());
        imovel.setFinalidade(dto.getFinalidade());
        imovel.setAreaTotal(dto.getAreaTotal());
        imovel.setValor(dto.getValor());
        imovel.setStatus(dto.getStatus());
        imovel.setDataCadastro(LocalDate.now());
        imovel.setProprietario(clienteOpt.get());
        
        // cria subentidade
        salvarSubEntidade(dto, imovel);

        imovelRepository.save(imovel);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{matricula}")
    public ResponseEntity<ImovelDTO> atualizarImovel(
            @PathVariable String matricula,
            @RequestBody ImovelDTO dto) {

        Optional<Imovel> opt = imovelRepository.findById(matricula);
        if (opt.isEmpty()) return ResponseEntity.notFound().build();

        Imovel imovel = opt.get();
        imovel.setEndereco(dto.getEndereco());
        imovel.setBairro(dto.getBairro());
        imovel.setCidade(dto.getCidade());
        imovel.setEstado(dto.getEstado());
        imovel.setCep(dto.getCep());
        imovel.setFinalidade(dto.getFinalidade());
        imovel.setAreaTotal(dto.getAreaTotal());
        imovel.setValor(dto.getValor());
        imovel.setStatus(dto.getStatus());
        imovel.setDataAtualizacao(LocalDate.now());

        // atualiza subentidade
        salvarSubEntidade(dto, imovel);

        imovelRepository.save(imovel);

        return ResponseEntity.ok(dto);
    }

    private void salvarSubEntidade(ImovelDTO dto, Imovel imovel) {
        String tipo = dto.getTipoImovel();

        switch (tipo) {
            case "TERRENO" -> {
                Terreno t = new Terreno();
                t.setImovel(imovel);
                t.setTopografia(dto.getTopografia());
                t.setTipoSolo(dto.getTipoSolo());
                terrenoRepository.save(t);
            }
            case "CASA" -> {
                UnidadeResidencial u = new UnidadeResidencial();
                u.setImovel(imovel);
                u.setNumeroQuartos(dto.getNumeroQuartos());
                u.setNumeroBanheiros(dto.getNumeroBanheiros());
                u.setNumeroSuites(dto.getNumeroSuites());
                u.setAreaConstruida(dto.getAreaConstruida());
                u.setNumeroVagasGaragem(dto.getNumeroVagasGaragem());
                u.setDescricao(dto.getDescricao());
                unidadeResidencialRepository.save(u);

                Casa c = new Casa();
                c.setImovel(imovel);
                c.setPossuiQuintal(dto.getPossuiQuintal());
                c.setNumeroPavimentos(dto.getNumeroPavimentos());
                casaRepository.save(c);
            }
            case "APARTAMENTO" -> {
                UnidadeResidencial u = new UnidadeResidencial();
                u.setImovel(imovel);
                u.setNumeroQuartos(dto.getNumeroQuartos());
                u.setNumeroBanheiros(dto.getNumeroBanheiros());
                u.setNumeroSuites(dto.getNumeroSuites());
                u.setAreaConstruida(dto.getAreaConstruida());
                u.setNumeroVagasGaragem(dto.getNumeroVagasGaragem());
                u.setDescricao(dto.getDescricao());
                unidadeResidencialRepository.save(u);

                Apartamento a = new Apartamento();
                a.setNumeroMatriculaImovel(imovel.getNumeroMatriculaImovel());
                a.setAndar(dto.getAndar());
                a.setNumeroApartamento(dto.getNumeroApartamento());
                a.setPossuiElevador(dto.getPossuiElevador());
                apartamentoRepository.save(a);
            }
            case "PREDIO_COMERCIAL" -> {
                UnidadeComercial u = new UnidadeComercial();
                u.setNumeroMatriculaImovel(imovel.getNumeroMatriculaImovel());
                u.setAreaUtil(dto.getAreaUtil());
                u.setDescricao(dto.getDescricao());
                unidadeComercialRepository.save(u);

                PredioComercial p = new PredioComercial();
                p.setNumeroMatriculaImovel(imovel.getNumeroMatriculaImovel());
                p.setTotalAndares(dto.getTotalAndares());
                p.setNumeroSalas(dto.getNumeroSalas());
                p.setPossuiEstacionamento(dto.getPossuiEstacionamento());
                predioComercialRepository.save(p);
            }
            case "SALA_COMERCIAL" -> {
                UnidadeComercial u = new UnidadeComercial();
                u.setNumeroMatriculaImovel(imovel.getNumeroMatriculaImovel());
                u.setAreaUtil(dto.getAreaUtil());
                u.setDescricao(dto.getDescricao());
                unidadeComercialRepository.save(u);

                SalaComercial s = new SalaComercial();
                s.setNumeroMatriculaImovel(imovel.getNumeroMatriculaImovel());
                s.setAndar(dto.getAndar());
                s.setNumeroSala(dto.getNumeroSala());
                salaComercialRepository.save(s);
            }
        }
    }

    private String descobrirTipoImovel(String matricula) {
        if (terrenoRepository.existsById(matricula)) return "TERRENO";
        if (casaRepository.existsById(matricula)) return "CASA";
        if (apartamentoRepository.existsById(matricula)) return "APARTAMENTO";
        if (predioComercialRepository.existsById(matricula)) return "PREDIO_COMERCIAL";
        if (salaComercialRepository.existsById(matricula)) return "SALA_COMERCIAL";
        return "DESCONHECIDO";
    }

    @GetMapping("/{numeroMatricula}")
    public ResponseEntity<ImovelDTO> buscarImovel(@PathVariable String numeroMatricula) {
        Optional<Imovel> imovelOpt = imovelRepository.findById(numeroMatricula);

        if (imovelOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Imovel imovel = imovelOpt.get();

        // Converte para DTO
        ImovelDTO dto = new ImovelDTO();
        dto.setNumeroMatriculaImovel(imovel.getNumeroMatriculaImovel());
        dto.setEndereco(imovel.getEndereco());
        dto.setBairro(imovel.getBairro());
        dto.setCidade(imovel.getCidade());
        dto.setEstado(imovel.getEstado());
        dto.setCep(imovel.getCep());
        dto.setValor(imovel.getValor());
        dto.setStatus(imovel.getStatus());
        dto.setDataCadastro(imovel.getDataCadastro().toString());
        dto.setDataAtualizacao(imovel.getDataAtualizacao() != null ? imovel.getDataAtualizacao().toString() : null);

        // Proprietário
        if (imovel.getProprietario() != null) {
            dto.setCpfProprietario(imovel.getProprietario().getCpf());
            dto.setCnpjProprietario(imovel.getProprietario().getCnpj());
            dto.setNomeProprietario(imovel.getProprietario().getPessoa().getNome());
        }

        // Descobrir tipo do imóvel
        dto.setTipoImovel(descobrirTipoImovel(numeroMatricula));

        return ResponseEntity.ok(dto);
    }
}
