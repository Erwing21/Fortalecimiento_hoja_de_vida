package com.estudiante.hojadevida;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private static final String COOKIE_ULTIMO_USUARIO = "ultimoUsuario";
    private static final int MAX_NOMBRE = 50;
    private static final int UN_MES = 60 * 60 * 24 * 30;
    private static final int MINUTOS_INACTIVIDAD = 30;


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("usuario") != null) {
            response.sendRedirect(request.getContextPath() + "/habilidades");
            return;
        }
        mostrarFormulario(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String usuario = request.getParameter("usuario");
        usuario = (usuario == null) ? "" : usuario.trim();

        String error = null;
        if (usuario.isEmpty()) {
            error = "Escribe tu nombre para iniciar sesión.";
        } else if (usuario.length() > MAX_NOMBRE) {
            error = "El nombre no puede superar " + MAX_NOMBRE + " caracteres.";
        }
        if (error != null) {
            request.setAttribute("mensajeError", error);
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            mostrarFormulario(request, response);
            return;
        }

        // Sesion: el nombre queda disponible para todas las paginas protegidas
        HttpSession session = request.getSession();
        request.changeSessionId(); // nuevo identificador al iniciar sesion
        session.setAttribute("usuario", usuario);
        session.setMaxInactiveInterval(MINUTOS_INACTIVIDAD * 60);

        // Cookie: solo el nombre (nada de claves). Se codifica porque una cookie no admite espacios ni tildes.
        Cookie cookie = new Cookie(COOKIE_ULTIMO_USUARIO, URLEncoder.encode(usuario, StandardCharsets.UTF_8));
        cookie.setMaxAge(UN_MES);
        cookie.setHttpOnly(true);
        cookie.setSecure(request.isSecure());
        cookie.setPath(request.getContextPath().isEmpty() ? "/" : request.getContextPath());
        response.addCookie(cookie); // debe ir antes de sendRedirect

        response.sendRedirect(request.getContextPath() + "/habilidades");
    }

    private void mostrarFormulario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("ultimoUsuario", leerUltimoUsuario(request));
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    private String leerUltimoUsuario(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null) {
            return null;
        }
        for (Cookie c : cookies) {
            if (COOKIE_ULTIMO_USUARIO.equals(c.getName())) {
                try {
                    return URLDecoder.decode(c.getValue(), StandardCharsets.UTF_8);
                } catch (IllegalArgumentException e) {
                    return null; // cookie manipulada: se ignora
                }
            }
        }
        return null;
    }
}
