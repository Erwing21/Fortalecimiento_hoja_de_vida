package com.estudiante.hojadevida;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/consulta")
public class ConsultaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nivel = request.getParameter("nivel");
        if (nivel == null || nivel.isBlank()) {
            nivel = "Todos";
        }

        boolean valido = nivel.equals("Todos") || nivel.equals("Básico")
                || nivel.equals("Intermedio") || nivel.equals("Avanzado");
        if (!valido) {
            request.setAttribute("mensajeError",
                    "Nivel no válido. Usa Básico, Intermedio, Avanzado o Todos.");
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            request.getRequestDispatcher("/WEB-INF/vistas/error.jsp").forward(request, response);
            return;
        }
        try {
            HabilidadDAO dao = new HabilidadDAO();
            List<Habilidad> resultado = nivel.equals("Todos") ? dao.listar() : dao.listarPorNivel(nivel);

            getServletContext().setAttribute("ultimoNivel", nivel);

            request.setAttribute("nivel", nivel);
            request.setAttribute("habilidades", resultado);
            request.getRequestDispatcher("/WEB-INF/consulta.jsp").forward(request, response);
        } catch (SQLException e) {
            log("Error consultando habilidades por nivel", e);
            request.setAttribute("mensajeError", "No se pudo consultar la base de datos.");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}
