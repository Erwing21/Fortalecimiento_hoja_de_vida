package com.estudiante.hojadevida;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/experiencia")
public class ExperienciaServlet extends HttpServlet {

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

        // experiencia.jsp escapa estos valores antes de mostrarlos
        request.setAttribute("puesto", puesto.trim());
        request.setAttribute("empresa", empresa.trim());
        request.setAttribute("duracion", duracion.trim());
        request.getRequestDispatcher("/WEB-INF/experiencia.jsp").forward(request, response);
    }
}
