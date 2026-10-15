package com.estudiante.hojadevida;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;


public class ConsultaServlet extends HttpServlet {

    @Override
    protected void doGet(@NotNull HttpServletRequest request, HttpServletResponse response)
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

        List<Habilidad> resultado = new ArrayList<>();
        for (Habilidad h : Habilidad.todas()) {
            if (nivel.equals("Todos") || h.getNivel().equals(nivel)) {
                resultado.add(h);
            }
        }

        getServletContext().setAttribute("ultimoNivel", nivel);

        request.setAttribute("nivel", nivel);
        request.setAttribute("habilidades", resultado);
        request.getRequestDispatcher("/WEB-INF/vistas/consulta.jsp").forward(request, response);
    }
}
