package com.maxamx.logista.domain.model.service.impl;

import com.maxamx.logista.domain.model.Cliente;
import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.StatusEntrega;
import com.maxamx.logista.domain.model.exception.ClienteException;
import com.maxamx.logista.domain.model.repository.ClienteRepository;
import com.maxamx.logista.domain.model.repository.EntregaRepository;
import com.maxamx.logista.domain.model.service.ClienteService;
import com.maxamx.logista.domain.model.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class SolicitacaoEntregaServiceImpl implements SolicitacaoEntregaService {

    private EntregaRepository entregaRepository;
    private ClienteService clienteService;


    @Transactional
    @Override
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = clienteService.buscar(entrega.getCliente().getId());
        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());
        return entregaRepository.save(entrega);
    }
}
