/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.service.impl;

import com.testing.clienteapi.model.Cliente;
import com.testing.clienteapi.model.util.Reply;
import com.testing.clienteapi.repositorio.ClienteRepositorio;
import com.testing.clienteapi.service.ClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Moises_F16.7.24
 */
@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepositorio repository;

    @Autowired
    public ClienteServiceImpl(ClienteRepositorio repository) {
        this.repository = repository;
    }

    @Override
    public List<Cliente> consultar(Cliente cliente) {
        return repository.buscar(cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getSexoId());
    }

    @Override
    public Reply guardar(Cliente cliente) {
        return repository.guardar(cliente.getClienteId(), cliente.getNombre(), cliente.getApellidoPaterno(), cliente.getApellidoMaterno(), cliente.getFechaNacimiento(), cliente.getSexoId(), cliente.getDireccion(), cliente.getCorreo());
    }

    @Override
    public Reply eliminar(Integer id) {
        return repository.eliminar(id);
    }

}
