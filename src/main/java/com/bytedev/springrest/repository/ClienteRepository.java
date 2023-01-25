package com.bytedev.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import com.bytedev.springrest.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  List<Cliente> findByNome(String nome);

  List<Cliente> findByNomeContaining(String nome);
}
