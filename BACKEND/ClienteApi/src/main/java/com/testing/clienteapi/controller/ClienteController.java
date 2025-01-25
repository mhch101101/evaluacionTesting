/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.controller;

import com.testing.clienteapi.model.Cliente;
import com.testing.clienteapi.model.util.Reply;
import com.testing.clienteapi.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Moises_F16.7.24
 */
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    @Autowired
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @PostMapping
    public List<Cliente> obtenerClientes(@RequestBody Cliente cliente) {
        return clienteService.consultar(cliente);
    }

    @PostMapping
    public Reply guardarCliente(@RequestBody Cliente cliente) {
        return clienteService.guardar(cliente);
    }

    @PostMapping
    public Reply eliminarCliente(@RequestBody Cliente cliente) {
        return clienteService.eliminar(cliente.getClienteId());
    }

}
