package com.estudiante.hojadevida;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HabilidadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Habilidad> habilidades = new HabilidadDAO().listar();
            request.setAttribute("habilidades", habilidades);
            request.getRequestDispatcher("/WEB-INF/habilidades.jsp").forward(request, response);
        } catch (SQLException e) {
            log("Error consultando habilidades", e);
            request.setAttribute("mensajeError", "No se pudo consultar la base de datos.");
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            request.getRequestDispatcher("/WEB-INF/error.jsp").forward(request, response);
        }
    }
}
