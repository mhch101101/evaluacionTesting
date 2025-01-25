/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.testing.clienteapi.model.util;

import java.io.Serializable;

/**
 *
 * @author Moises_F16.7.24
 */
public class Reply implements Serializable {

    private Boolean success;
    private String mensaje;

    public Reply(Boolean success, String mensaje) {
        this.success = success;
        this.mensaje = mensaje;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
