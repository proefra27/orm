package com.upiiz.orm.controllers;

import com.upiiz.orm.models.ClienteEntity;
import com.upiiz.orm.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    //Que dependiencia inyectamos
    @Autowired
    ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteEntity>> getClientes(){
        return ResponseEntity.ok(clienteService.obtenerTodos());
    }

    @PostMapping
    public ResponseEntity<ClienteEntity> guardar(@RequestBody @Validated ClienteEntity cliente){
        return ResponseEntity.ok(clienteService.guardarCliente(cliente));
    }
}
