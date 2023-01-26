package com.bytedev.springrest.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bytedev.springrest.model.Entrega;
import com.bytedev.springrest.model.StatusEntrega;
import com.bytedev.springrest.repository.EntregaRepository;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

  private EntregaRepository entregaRepository;

  @Transactional
  public Entrega solicitar(Entrega entrega) {

    entrega.setStatus(StatusEntrega.PENDENTE);
    entrega.setDataPedido(LocalDateTime.now());

    return entregaRepository.save(entrega);
  }
}
