package com.bytedev.springrest.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bytedev.springrest.model.Entrega;
import com.bytedev.springrest.repository.EntregaRepository;
import com.bytedev.springrest.service.SolicitacaoEntregaService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

  private SolicitacaoEntregaService solicitacaoEntregaService;
  private EntregaRepository entregaRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega solicitar(@RequestBody Entrega entrega) {

    return solicitacaoEntregaService.solicitar(entrega);
  }

  @GetMapping
  public List<Entrega> listar() {
    return entregaRepository.findAll();
  }

  @GetMapping("/{entregaId}")
  public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {

    return entregaRepository.findById(entregaId)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

}
