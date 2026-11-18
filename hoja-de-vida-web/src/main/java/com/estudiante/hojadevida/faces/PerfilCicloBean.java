package com.estudiante.hojadevida.faces;

import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.io.Serializable;


@Named("perfilCiclo")
@ViewScoped
public class PerfilCicloBean implements Serializable {

    private static final long serialVersionUID = 1L;


    private String cargoObjetivo;
    private String resumen;


    private int accionesEjecutadas;
    private String confirmacion;


    public String guardar() {
        accionesEjecutadas++;
        confirmacion = "Perfil guardado: " + cargoObjetivo.trim()
                + " (" + resumen.trim().length() + " caracteres en el resumen).";
        System.out.println("[Semana 16 | PerfilCicloBean] guardar() EJECUTADA (fase 5 Invoke Application). "
                + "Acciones ejecutadas: " + accionesEjecutadas);
        return null; // null = se queda en la misma vista
    }


    public String getCargoObjetivo() {
        return cargoObjetivo;
    }

    public void setCargoObjetivo(String cargoObjetivo) {
        this.cargoObjetivo = cargoObjetivo;
    }

    public String getResumen() {
        return resumen;
    }

    public void setResumen(String resumen) {
        this.resumen = resumen;
    }

    public int getAccionesEjecutadas() {
        return accionesEjecutadas;
    }

    public String getConfirmacion() {
        return confirmacion;
    }
}