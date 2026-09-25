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
        String puesto = request.getParameter("puesto");
        String empresa = request.getParameter("empresa");
        String duracion = request.getParameter("duracion");

        response.setContentType("text/html;charset=UTF-8");

        // Validacion basica: ningun campo puede llegar vacio
        if (puesto == null || puesto.trim().isEmpty()
                || empresa == null || empresa.trim().isEmpty()
                || duracion == null || duracion.trim().isEmpty()) {
            response.getWriter().println("<h1>Faltan datos</h1>");
            response.getWriter().println("<p>Puesto, empresa y duracion son obligatorios.</p>");
            return;
        }

        response.getWriter().println("<h1>Experiencia registrada</h1>");
        response.getWriter().println("<p>Puesto: " + puesto + "</p>");
        response.getWriter().println("<p>Empresa: " + empresa + "</p>");
        response.getWriter().println("<p>Duracion: " + duracion + "</p>");
    }
}