package com.estudiante.hojadevida;

import com.estudiante.hojadevida.modelo.Experiencia;
import com.estudiante.hojadevida.servicio.ExperienciaService;
import jakarta.ejb.EJB;
import java.util.List;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/experiencia")
public class ExperienciaServlet extends HttpServlet {

    @EJB
    private ExperienciaService servicio;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Experiencia> experiencias = servicio.listar();
            request.setAttribute("experiencias", experiencias);
            request.getRequestDispatcher("/WEB-INF/experiencia.jsp").forward(request, response);
        } catch (RuntimeException e) {
            mostrarError(request, response, e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String puesto = request.getParameter("puesto");
        String empresa = request.getParameter("empresa");
        String duracion = request.getParameter("duracion");

        if (puesto == null || puesto.trim().isEmpty()
                || empresa == null || empresa.trim().isEmpty()
                || duracion == null || duracion.trim().isEmpty()) {
            request.setAttribute("mensajeError", "Puesto, empresa y duración son obligatorios.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            return;
        }

        if (puesto.trim().length() > 100 || empresa.trim().length() > 100 || duracion.trim().length() > 50) {
            request.setAttribute("mensajeError",
                    "Puesto y empresa admiten hasta 100 caracteres, y la duración hasta 50.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
            return;
        }

        try {
            servicio.registrar(puesto.trim(), empresa.trim(), duracion.trim());
        } catch (RuntimeException e) {
            mostrarError(request, response, e);
            return;
        }

        response.sendRedirect(request.getContextPath() + "/experiencia?guardada=1");
    }

    private void mostrarError(HttpServletRequest request, HttpServletResponse response, RuntimeException e)
            throws ServletException, IOException {
        log("Error con la base de datos (EJB/JPA)", e); // el detalle queda en la consola del servidor
        request.setAttribute("mensajeError", "No se pudo completar la operación con la base de datos.");
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
    }
}
