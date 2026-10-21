<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ page import="jakarta.servlet.http.HttpSession, com.estudiante.hojadevida.Texto" %>
<%
  // getSession(false): consulta la sesion sin crear una nueva para visitantes anonimos
  HttpSession sesionMenu = request.getSession(false);
  String usuarioMenu = (sesionMenu == null) ? null : (String) sesionMenu.getAttribute("usuario");
  String base = request.getContextPath();
%>
<nav class="menu">
  <strong>Hoja de Vida Estudiantil</strong>
  <div class="menu-links">
    <a href="<%= base %>/index.html">Inicio</a>
    <% if (usuarioMenu != null) { %>
      <a href="<%= base %>/consejo">Consejo del día</a>
      <a href="<%= base %>/Experiencia.html">Registrar experiencia</a>
      <a href="<%= base %>/habilidades">Habilidades</a>
      <a href="<%= base %>/consulta">Consulta por nivel</a>
      <span class="usuario-activo">Usuario: <%= Texto.escapar(usuarioMenu) %></span>
      <form method="post" action="<%= base %>/logout" class="form-salir">
        <button type="submit" class="btn-salir">Cerrar sesión</button>
      </form>
    <% } else { %>
      <a href="<%= base %>/login">Iniciar sesión</a>
    <% } %>
  </div>
</nav>