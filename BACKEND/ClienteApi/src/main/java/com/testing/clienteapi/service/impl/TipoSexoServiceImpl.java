/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.service.impl;

import com.testing.clienteapi.model.Cliente;
import com.testing.clienteapi.model.TipoSexo;
import com.testing.clienteapi.repositorio.SexoRepositorio;
import com.testing.clienteapi.service.TipoSexoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Moises_F16.7.24
 */
@Service
public class TipoSexoServiceImpl implements TipoSexoService {

    private final SexoRepositorio repository;

    @Autowired
    public TipoSexoServiceImpl(SexoRepositorio repository) {
        this.repository = repository;
    }

    @Override
    public List<TipoSexo> consultar() {
        return repository.buscar();
    }
}
