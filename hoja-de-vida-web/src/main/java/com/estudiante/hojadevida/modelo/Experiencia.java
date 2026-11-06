package com.estudiante.hojadevida.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "experiencias")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "puesto", nullable = false, length = 100)
    private String puesto;

    @Column(name = "empresa", nullable = false, length = 100)
    private String empresa;

    @Column(name = "duracion", nullable = false, length = 50)
    private String duracion;


    protected Experiencia() { }

    public Experiencia(String puesto, String empresa, String duracion) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.duracion = duracion;
    }

    public Long getId() { return id; }

    public String getPuesto() { return puesto; }

    public String getEmpresa() { return empresa; }

    public String getDuracion() { return duracion; }
}
