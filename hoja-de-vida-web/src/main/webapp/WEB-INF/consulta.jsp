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
      <p>Nivel consultado: <strong><%= Texto.escapar(nivel) %></strong></p>

    <% if (habilidades.isEmpty()) { %>
      <p>No hay habilidades en este nivel.</p>
    <% } else { %>
      <table class="tabla-datos">
        <thead>
          <tr><th>ID</th><th>Habilidad</th><th>Nivel</th></tr>
        </thead>
        <tbody>
          <% for (Habilidad h : habilidades) { %>
            <tr>
              <td><%= h.getId() %></td>
              <td><%= Texto.escapar(h.getNombre()) %></td>
              <td><%= Texto.escapar(h.getNivel()) %></td>
            </tr>
          <% } %>
        </tbody>
      </table>
    <% } %>
    <%-- application: valor compartido por toda la aplicacion (lo guarda ConsultaServlet) --%>
    <p>Último nivel consultado en la aplicación: <%= Texto.escapar((String) application.getAttribute("ultimoNivel")) %></p>
  </main>
</body>
</html>
