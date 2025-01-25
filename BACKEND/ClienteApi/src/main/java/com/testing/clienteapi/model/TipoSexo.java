/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Moises_F16.7.24
 */
@Entity
public class TipoSexo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEXO_ID")
    @javax.persistence.Id
    private Integer sexoId;

    @Column(name = "NOMBRE")
    private String nombre;

    public Integer getSexoId() {
        return sexoId;
    }

    public void setSexoId(Integer sexoId) {
        this.sexoId = sexoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
