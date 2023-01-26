package com.bytedev.springrest.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class Destinatario {

  @Column(name = "destinario_nome")
  private String nome;

  @Column(name = "destinario_logradouro")
  private String logradouro;

  @Column(name = "destinario_numero")
  private String numero;

  @Column(name = "destinario_complemento")
  private String complemento;

  @Column(name = "destinario_bairro")
  private String bairro;
}
