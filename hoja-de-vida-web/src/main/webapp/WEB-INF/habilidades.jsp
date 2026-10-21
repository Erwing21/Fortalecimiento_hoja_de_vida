<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List, com.estudiante.hojadevida.Habilidad" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Mis habilidades</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
  <header class="hero">
    <jsp:include page="/WEB-INF/menu.jsp" />
    <h1>Mis habilidades</h1>
  </header>
  <main style="padding: 20px 10%;">
    <%-- HabilidadServlet consulta la base de datos; la JSP solo muestra los registros --%>
    <%
      String usuario = (String) session.getAttribute("usuario");
      List<Habilidad> habilidades = (List<Habilidad>) request.getAttribute("habilidades");
    %>
    <p>Sesión activa de: <strong><%= Texto.escapar(usuario) %></strong></p>

    <% if (habilidades.isEmpty()) { %>
      <p>No hay habilidades registradas en la base de datos.</p>
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
    <p>Total de habilidades mostradas: <%= habilidades.size() %></p>
  </main>
</body>
</html>
