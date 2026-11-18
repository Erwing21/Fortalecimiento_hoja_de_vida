package com.estudiante.hojadevida.faces;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Named("registroHabilidades")
@SessionScoped
public class RegistroHabilidadesBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private String nombre;
    private String nivel;
    private Integer horas;


    private final List<HabilidadPractica> habilidades = new ArrayList<>();


    public String agregar() {
        habilidades.add(new HabilidadPractica(nombre.trim(), nivel.trim(), horas));

        nombre = null;
        nivel = null;
        horas = null;
        return null;
    }


    public int getTotal() {
        return habilidades.size();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

  
    public List<HabilidadPractica> getHabilidades() {
        return habilidades;
    }
}
