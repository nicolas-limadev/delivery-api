package com.bytedev.springrest.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bytedev.springrest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  List<Cliente> findByNome(String nome);

  List<Cliente> findByNomeContaining(String nome);

  Optional<Cliente> findByEmail(String email);
}
