/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.controller;

import com.testing.clienteapi.model.TipoSexo;
import com.testing.clienteapi.service.TipoSexoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Moises_F16.7.24
 */
@RestController
@RequestMapping("/tipoSexo")
public class TipoSexoController {

    private final TipoSexoService service;

    @Autowired
    public TipoSexoController(TipoSexoService service) {
        this.service = service;
    }

    @PostMapping
    public List<TipoSexo> obtener() {
        return service.consultar();
    }

}
