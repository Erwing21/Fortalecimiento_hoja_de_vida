package com.estudiante.hojadevida.servicio;

import com.estudiante.hojadevida.modelo.Experiencia;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import java.util.List;


@Stateless
public class ExperienciaService {

    // EntityManager: JPA/Hibernate traduce estas operaciones a SQL
    @PersistenceContext(unitName = "hojaDeVidaPU")
    private EntityManager em;

    public void registrar(String puesto, String empresa, String duracion) {
        em.persist(new Experiencia(puesto, empresa, duracion));
    }

    public List<Experiencia> listar() {
        return em.createQuery("SELECT e FROM Experiencia e ORDER BY e.id", Experiencia.class)
                .getResultList();
    }
}
