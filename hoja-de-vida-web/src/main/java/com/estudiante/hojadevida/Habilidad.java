package com.estudiante.hojadevida;

import java.util.List;

public class Habilidad {

    private final int id;
    private final String nombre;
    private final String nivel;

    public Habilidad(int id, String nombre, String nivel) {
        this.id = id;
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNivel() {
        return nivel;
    }

}
