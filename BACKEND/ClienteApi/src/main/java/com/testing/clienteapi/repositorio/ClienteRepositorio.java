/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.repositorio;

import com.testing.clienteapi.model.Cliente;
import com.testing.clienteapi.model.util.Reply;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Moises_F16.7.24
 */
@Repository
public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {

    @Query("CALL MANTENIMIENTO_CLIENTE.CONSULTAR(:parametro1, :parametro2, :parametro3, :parametro4)")
    List<Cliente> buscar(@Param("parametro1") String nombre, @Param("parametro2") String apePat, @Param("parametro3") String apeMat, @Param("parametro4") Integer sexoId);

    @Query("CALL MANTENIMIENTO_CLIENTE.GUARDAR(:parametro1, :parametro2, :parametro3, :parametro4, :parametro5, :parametro6, :parametro7, :parametro8)")
    Reply guardar(@Param("parametro1") Integer id,
            @Param("parametro2") String nombre,
            @Param("parametro3") String apePat,
            @Param("parametro4") String apeMat,
            @Param("parametro5") Date fecha,
            @Param("parametro6") Integer sexoId,
            @Param("parametro7") String direccion,
            @Param("parametro8") String correo);

    @Query("CALL MANTENIMIENTO_CLIENTE.ELIMINAR(:id)")
    Reply eliminar(@Param("id") Integer id);

}
