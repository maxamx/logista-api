package com.maxamx.logista.domain.model.service;

import com.maxamx.logista.domain.model.Ocorrencia;

public interface RegistroOcorrenciaService {
    Ocorrencia registrar(Long entregaId, String descricao);
}
