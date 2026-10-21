package com.estudiante.hojadevida;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebFilter(urlPatterns = {"/habilidades", "/consulta", "/consejo", "/experiencia", "/Experiencia.html"})
public class SesionFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession(false);
        boolean conSesion = session != null && session.getAttribute("usuario") != null;

        if (!conSesion) {
            response.sendRedirect(request.getContextPath() + "/login");
            return;
        }
        // Que el boton "atras" no muestre paginas privadas despues de cerrar sesion
        response.setHeader("Cache-Control", "no-store");
        chain.doFilter(req, res);
    }
}
