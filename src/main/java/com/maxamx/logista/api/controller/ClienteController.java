package com.maxamx.logista.api.controller;

import com.maxamx.logista.domain.model.Cliente;
import com.maxamx.logista.domain.model.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController
@AllArgsConstructor
public class ClienteController {

    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return clienteRepository.findAll();
    }

    @GetMapping("/clientes/{clienteId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clienteId){
//        Optional<Cliente> cliente = clienteRepository.findById(clienteId);
//        if( cliente.isPresent()){
//            return ResponseEntity.ok(cliente.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }

        return clienteRepository.findById(clienteId)
                .map(cliente ->ResponseEntity.ok(cliente) )
                .orElse(ResponseEntity.notFound().build());

    }

}
