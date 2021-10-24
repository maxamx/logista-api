package com.maxamx.logista.domain.model.service.impl;

import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.exception.EntregaException;
import com.maxamx.logista.domain.model.repository.EntregaRepository;
import com.maxamx.logista.domain.model.service.BuscaEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaServiceImpl implements BuscaEntregaService {

    private EntregaRepository entregaRepository;

    @Override
    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow( ()-> new EntregaException("Entrega não encontrada"));
    }
}
