package com.estudiante.hojadevida;



import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/** Controlador: prepara la lista de habilidades y la envia a habilidades.jsp. */
public class HabilidadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("habilidades", Habilidad.todas());
        request.getRequestDispatcher("/WEB-INF/vistas/habilidades.jsp").forward(request, response);
    }
}
