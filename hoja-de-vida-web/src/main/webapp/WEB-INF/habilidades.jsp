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
    <% List<Habilidad> habilidades = (List<Habilidad>) request.getAttribute("habilidades"); %>
    <ul>
      <% for (Habilidad h : habilidades) { %>
        <li><%= h.getNombre() %> — <%= h.getNivel() %></li>
      <% } %>
    </ul>
    <p>Total de habilidades mostradas: <%= habilidades.size() %></p>
  </main>
</body>
</html>