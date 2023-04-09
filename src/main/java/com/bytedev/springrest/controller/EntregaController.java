package com.bytedev.springrest.controller;

import com.bytedev.springrest.model.Entrega;
import com.bytedev.springrest.repository.EntregaRepository;
import com.bytedev.springrest.service.SolicitacaoEntregaService;
import java.util.List;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

  private SolicitacaoEntregaService solicitacaoEntregaService;
  private EntregaRepository entregaRepository;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public Entrega solicitar(@Valid @RequestBody Entrega entrega) {
    return solicitacaoEntregaService.solicitar(entrega);
  }

  @GetMapping
  public List<Entrega> listar() {
    return entregaRepository.findAll();
  }

  @GetMapping("/{entregaId}")
  public ResponseEntity<Entrega> buscar(@PathVariable Long entregaId) {
    return entregaRepository
      .findById(entregaId)
      .map(ResponseEntity::ok)
      .orElse(ResponseEntity.notFound().build());
  }
}
