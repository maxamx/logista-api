package com.maxamx.logista.api.controller;

import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {
    private SolicitacaoEntregaService solicitacaoEntregaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return solicitacaoEntregaService.solicitar(entrega);
    }
}