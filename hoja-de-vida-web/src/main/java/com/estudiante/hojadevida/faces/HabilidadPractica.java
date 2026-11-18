package com.estudiante.hojadevida.faces;

import java.io.Serializable;


public class HabilidadPractica implements Serializable {

    private static final long serialVersionUID = 1L;

    private final String nombre;
    private final String nivel;
    private final Integer horas;

    public HabilidadPractica(String nombre, String nivel, Integer horas) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.horas = horas;
    }


    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public Integer getHoras() {
        return horas;
    }
}
