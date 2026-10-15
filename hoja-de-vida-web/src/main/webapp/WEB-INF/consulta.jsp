<%@ page contentType="text/html;charset=UTF-8" errorPage="error.jsp" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Consulta de habilidades</title>
   <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
  </head>
  <body>
    <header class="hero">
      <jsp:include page="/WEB-INF/menu.jsp" />
      <h1>Consulta de habilidades por nivel</h1>
    </header>
    <main style="padding: 20px 10%;">
      <p>
        <a href="<%= request.getContextPath() %>/consulta">Todos</a> |
        <a href="<%= request.getContextPath() %>/consulta?nivel=Básico">Básico</a> |
        <a href="<%= request.getContextPath() %>/consulta?nivel=Intermedio">Intermedio</a> |
        <a href="<%= request.getContextPath() %>/consulta?nivel=Avanzado">Avanzado</a> |
        <a href="<%= request.getContextPath() %>/consulta?nivel=Experto">Probar error</a>
      </p>
      <%
        String nivel = (String) request.getAttribute("nivel");
        List<Habilidad> habilidades = (List<Habilidad>) request.getAttribute("habilidades");
      %>
      <p>Nivel consultado: <%= nivel %></p>
      <ul>
        <% for (Habilidad h : habilidades) { %>
          <li><%= h.getNombre() %> — <%= h.getNivel() %></li>
        <% } %>
        <% if (habilidades.isEmpty()) { %>
          <li>No hay habilidades en este nivel.</li>
        <% } %>
      </ul>
      <%-- application: valor compartido por toda la aplicacion (lo guarda ConsultaServlet) --%>
      <p>Último nivel consultado en la aplicación: <%= application.getAttribute("ultimoNivel") %></p>
    </main>
  </body>
  </html>
