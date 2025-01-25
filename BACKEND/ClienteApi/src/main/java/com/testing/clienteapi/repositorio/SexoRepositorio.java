/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.repositorio;

import com.testing.clienteapi.model.TipoSexo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moises_F16.7.24
 */
@Repository
public interface SexoRepositorio extends JpaRepository<TipoSexo, Long> {

    @Query("CALL MANTENIMIENTO_TIPO_SEXO.CONSULTAR()")
    public List<TipoSexo> buscar();

}
