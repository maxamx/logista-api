package com.maxamx.logista.domain.model.service.impl;

import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.repository.EntregaRepository;
import com.maxamx.logista.domain.model.service.BuscaEntregaService;
import com.maxamx.logista.domain.model.service.FinalizacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaServiceImpl implements FinalizacaoEntregaService {


    private BuscaEntregaService buscaEntregaService;
    private EntregaRepository entregaRepository;

    @Transactional
    @Override
    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        entrega.finalizar();
        entregaRepository.save(entrega);
    }
}
