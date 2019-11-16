package com.kevin.spring.mongodb.services.impl;

import com.kevin.spring.mongodb.documents.Cliente;
import com.kevin.spring.mongodb.repositories.ClienteRepository;
import com.kevin.spring.mongodb.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

  @Autowired
  private ClienteRepository clienteRepository;

  @Override
  public List<Cliente> listarTodos() {
    return this.clienteRepository.findAll();
  }

//  @Override
//  public Cliente listarPorId(Cliente id) {
//    return this.clienteRepository.findOne(id);
//  }

  @Override
  public Cliente cadastrar(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  @Override
  public Cliente atualizar(Cliente cliente) {
    return this.clienteRepository.save(cliente);
  }

  @Override
  public void remover(Cliente id) {
    this.clienteRepository.delete(id);
  }
}
