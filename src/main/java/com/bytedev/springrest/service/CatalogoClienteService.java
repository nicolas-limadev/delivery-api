package com.bytedev.springrest.service;

import com.bytedev.springrest.expection.NegocioException;
import com.bytedev.springrest.model.Cliente;
import com.bytedev.springrest.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

  private ClienteRepository clienteRepository;

  public Cliente buscar(Long clienteId) {
    return clienteRepository
      .findById(clienteId)
      .orElseThrow(() -> new NegocioException("Cliente não encontrado"));
  }

  @Transactional
  public Cliente salvar(Cliente cliente) {
    boolean emailEmUso = clienteRepository
      .findByEmail(cliente.getEmail())
      .stream()
      .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

    if (emailEmUso) {
      throw new NegocioException(
        "Já existe um cliente cadastrado com este e-mail."
      );
    }

    return clienteRepository.save(cliente);
  }

  @Transactional
  public void excluir(Long clientId) {
    clienteRepository
      .findById(clientId)
      .orElseThrow(() -> new NegocioException("ID não encontrado"));

    clienteRepository.deleteById(clientId);
  }
}
