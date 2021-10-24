package com.maxamx.logista.domain.model.service.impl;

import com.maxamx.logista.domain.model.Cliente;
import com.maxamx.logista.domain.model.exception.ClienteException;
import com.maxamx.logista.domain.model.repository.ClienteRepository;
import com.maxamx.logista.domain.model.service.ClienteService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ClienteServiceImpl implements ClienteService {

    private ClienteRepository clienteRepository;

    @Override
    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));
        if(emailEmUso){
            throw new ClienteException("Existe cliente cadastrado eom este e-mail");
        }

        return clienteRepository.save(cliente);
    }

    @Override
    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Cliente buscar(Long id){
        return clienteRepository.findById(id)
                .orElseThrow(()-> new ClienteException("Cliente não encontrado"));
    }
}
