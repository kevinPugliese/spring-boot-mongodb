package com.kevin.spring.mongodb.services;

import com.kevin.spring.mongodb.documents.Cliente;

import java.util.List;

public interface ClienteService {

  List<Cliente> listarTodos();

//  Cliente listarPorId(String id);

  Cliente cadastrar(Cliente cliente);

  Cliente atualizar(Cliente cliente);

  void remover(Cliente id);
}
