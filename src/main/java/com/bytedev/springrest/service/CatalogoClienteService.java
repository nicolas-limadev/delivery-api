package com.bytedev.springrest.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytedev.springrest.expection.NegocioException;
import com.bytedev.springrest.model.Cliente;
import com.bytedev.springrest.repository.ClienteRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

  private ClienteRepository clienteRepository;

  @Transactional
  public Cliente salvar(Cliente cliente) {

    boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail()).stream()
        .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

    if (emailEmUso) {
      throw new NegocioException("Já existe um cliente cadastrado com este e-mail.");
    }

    return clienteRepository.save(cliente);
  }

  @Transactional
  public void excluir(Long clientId) {
    clienteRepository.deleteById(clientId);
  }
}