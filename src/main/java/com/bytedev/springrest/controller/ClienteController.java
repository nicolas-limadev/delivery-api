package com.bytedev.springrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bytedev.springrest.model.Cliente;
import com.bytedev.springrest.repository.ClienteRepository;
import com.bytedev.springrest.service.CatalogoClienteService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Cliente> buscar(@PathVariable Long clientId) {

        return clienteRepository.findById(clientId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicionar(@Valid @RequestBody Cliente cliente) {
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long clientId, @Valid @RequestBody Cliente cliente) {

        if (!clienteRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        cliente.setId(clientId);
        cliente = catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> excluir(@PathVariable Long clientId) {

        if (!clienteRepository.existsById(clientId)) {
            return ResponseEntity.notFound().build();
        }

        catalogoClienteService.excluir(clientId);

        return ResponseEntity.noContent().build();
    }
}
