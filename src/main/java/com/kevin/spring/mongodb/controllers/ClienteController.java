package com.kevin.spring.mongodb.controllers;

import com.kevin.spring.mongodb.documents.Cliente;
import com.kevin.spring.mongodb.responses.Response;
import com.kevin.spring.mongodb.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/clientes")
public class ClienteController {

  @Autowired
  private ClienteService clienteService;

  @GetMapping
  public ResponseEntity<Response<List<Cliente>>> listarTodos() {
    return ResponseEntity.ok(new Response<List<Cliente>>(this.clienteService.listarTodos()));
  }

  @PostMapping
  public ResponseEntity<Response<Cliente>> cadastrar(@Valid @RequestBody Cliente cliente, BindingResult result) {
    if (result.hasErrors()) {
      List<String> erros = new ArrayList<String>();
      result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
      Response<Cliente> clienteResponse = new Response<>(cliente);
      clienteResponse.setErros(erros);
      return ResponseEntity.badRequest().body(clienteResponse);
    }

    return ResponseEntity.ok(new Response<Cliente>(this.clienteService.cadastrar(cliente)));
  }
}
