/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.service;

import com.testing.clienteapi.model.Cliente;
import com.testing.clienteapi.model.util.Reply;
import java.util.List;

/**
 *
 * @author Moises_F16.7.24
 */
public interface ClienteService {

    public List<Cliente> consultar(Cliente cliente);

    public Reply guardar(Cliente cliente);

    public Reply eliminar(Integer cliente);
}
