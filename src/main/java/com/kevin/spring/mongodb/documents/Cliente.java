package com.kevin.spring.mongodb.documents;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Document
public class Cliente {

  @Id
  private String id;
  private String nome;
  private String email;
  private String cpf;

  public Cliente() {
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @NotEmpty(message = "Nome não pode ser vazio")
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  @NotEmpty(message = "Email não pode ser vazio")
  @Email(message = "Email inválido")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @NotEmpty(message = "CPF não pode ser vazio")
  @CPF(message = "CPF inválido")
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
}
