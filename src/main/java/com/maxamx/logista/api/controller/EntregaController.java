package com.maxamx.logista.api.controller;

import com.maxamx.logista.api.dto.output.EntregaOutputDTO;
import com.maxamx.logista.api.dto.input.EntregaInputDTO;
import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.repository.EntregaRepository;
import com.maxamx.logista.domain.model.service.SolicitacaoEntregaService;
import com.maxamx.logista.mapper.EntregaMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaRepository entregaRepository;
    private EntregaMapper entregaMapper;



    @PostMapping
    public Entrega solicitar(@Valid @RequestBody EntregaInputDTO entregaInputDTO){
        Entrega novaEntrega = entregaMapper.toEntity(entregaInputDTO);
        return solicitacaoEntregaService.solicitar(novaEntrega);
    }

    @GetMapping
    public List<EntregaOutputDTO> listar(){
        return entregaMapper.toCollectionDTO(entregaRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EntregaOutputDTO> buscar(@PathVariable Long id){
        return entregaRepository.findById(id)
                .map(entrega->ResponseEntity.ok(entregaMapper.toDTO(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
