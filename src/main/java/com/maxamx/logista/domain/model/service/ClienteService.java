package com.maxamx.logista.domain.model.service;

import com.maxamx.logista.domain.model.Cliente;

public interface ClienteService {
   Cliente salvar(Cliente cliente);
   void excluir(Long id);
}
