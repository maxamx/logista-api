package com.maxamx.logista.domain.model.service.impl;

import com.maxamx.logista.domain.model.Entrega;
import com.maxamx.logista.domain.model.Ocorrencia;
import com.maxamx.logista.domain.model.service.BuscaEntregaService;
import com.maxamx.logista.domain.model.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaServiceImpl implements RegistroOcorrenciaService {

    private BuscaEntregaService buscaEntregaService;

    @Transactional
    @Override
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return entrega.adiconarOcorrencia(descricao);

    }
}
