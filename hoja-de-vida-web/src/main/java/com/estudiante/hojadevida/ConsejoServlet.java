package com.estudiante.hojadevida;

import java.io.IOException;
import java.util.List;
import java.util.Random;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ConsejoServlet extends HttpServlet {

    private static final List<String> CONSEJOS = List.of(
            "Usa un correo profesional: evita apodos o numeros aleatorios.",
            "Escribe un perfil breve de 2 a 3 lineas sobre quien eres y que buscas.",
            "Destaca logros, no solo tareas: usa numeros cuando puedas.",
            "Ordena tu experiencia de la mas reciente a la mas antigua.",
            "Cuida la ortografia y manten un mismo estilo de letra en todo el documento.",
            "Adapta tu hoja de vida a cada oferta a la que apliques."
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String consejo = CONSEJOS.get(new Random().nextInt(CONSEJOS.size()));
        response.getWriter().println("<h1>Consejo del dia</h1><p>" + consejo + "</p>");
    }
}
