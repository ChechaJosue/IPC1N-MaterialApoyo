/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serializacion;

import java.io.Serializable;

/**
 *
 * @author chechajosue
 */
public class Configuracion implements Serializable {
    
    String nombre;
    String slogan;

    public Configuracion(String nombre, String slogan) {
        this.nombre = nombre;
        this.slogan = slogan;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }
}
