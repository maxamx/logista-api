package com.maxamx.logista.api.controller;

import com.maxamx.logista.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente = new Cliente();
        cliente.setId(1L);
        cliente.setNome("Joaõ");
        cliente.setEmail("joao.logista@teste.com");
        cliente.setTelefone("61 88887777");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Maria");
        cliente2.setEmail("maria.logista@teste.com");
        cliente2.setTelefone("61 66668888");

        return Arrays.asList(cliente, cliente2);
    }
}
