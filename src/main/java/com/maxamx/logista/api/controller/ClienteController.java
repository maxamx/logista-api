package com.maxamx.logista.api.controller;

import com.maxamx.logista.domain.model.Cliente;
import com.maxamx.logista.domain.model.repository.ClienteRepository;
import com.maxamx.logista.domain.model.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;

    private ClienteService clienteService;

    @GetMapping()
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
        return clienteRepository.findById(clienteId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente){
        return clienteService.salvar(cliente);
    }

    @PutMapping("/{clienteId}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long clienteId, @RequestBody Cliente cliente){
        if(!clienteRepository.existsById(clienteId)){
            return ResponseEntity.notFound().build();
        }
        cliente.setId(clienteId);
        cliente = clienteService.salvar(cliente);
        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}")
    public ResponseEntity<Cliente> remover(@PathVariable Long clienteId){
        if (!clienteRepository.existsById(clienteId)){
           return ResponseEntity.notFound().build();
        }
        clienteService.excluir(clienteId);
        return ResponseEntity.noContent().build();

    }

}
