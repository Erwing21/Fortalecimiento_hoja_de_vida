package com.estudiante.hojadevida;

import java.util.List;


public class Habilidad {

    private final String nombre;
    private final String nivel;

    public Habilidad(String nombre, String nivel) {
        this.nombre = nombre;
        this.nivel = nivel;
    }

    public String getNombre() { return nombre; }

    public String getNivel() { return nivel; }


    public static List<Habilidad> todas() {
        return List.of(
                new Habilidad("HTML5", "Avanzado"),
                new Habilidad("CSS3", "Intermedio"),
                new Habilidad("JavaScript", "Avanzado"),
                new Habilidad("Java", "Básico"));
    }
}
