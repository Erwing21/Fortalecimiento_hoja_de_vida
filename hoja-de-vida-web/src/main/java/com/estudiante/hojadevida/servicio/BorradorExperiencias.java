package com.estudiante.hojadevida.servicio;

import jakarta.ejb.Stateful;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Stateful
public class BorradorExperiencias implements Serializable {

    private final List<String> pendientes = new ArrayList<>();

    public void agregar(String descripcion) {
        pendientes.add(descripcion);
    }

    public List<String> consultar() {
        return new ArrayList<>(pendientes);
    }
}