<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ page import="com.estudiante.hojadevida.Texto" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Iniciar sesión</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
  <header class="hero">
    <jsp:include page="/WEB-INF/menu.jsp" />
    <h1>Iniciar sesión</h1>
  </header>
  <main style="padding: 20px 10%;">
    <%-- LoginServlet envia mensajeError y ultimoUsuario (leido de la cookie) --%>
    <%
      String mensajeError = (String) request.getAttribute("mensajeError");
      String ultimoUsuario = (String) request.getAttribute("ultimoUsuario");
    %>
    <% if (mensajeError != null) { %>
      <p class="mensaje-error"><%= Texto.escapar(mensajeError) %></p>
    <% } %>
    <% if (ultimoUsuario != null) { %>
      <p>Último usuario en este navegador: <strong><%= Texto.escapar(ultimoUsuario) %></strong></p>
    <% } %>

    <form method="post" action="<%= request.getContextPath() %>/login" class="form-login">
      <label for="usuario">Nombre de usuario</label>
      <input id="usuario" name="usuario" maxlength="50" required autofocus
             value="<%= Texto.escapar(ultimoUsuario) %>">
      <button type="submit">Entrar</button>
    </form>
  </main>
</body>
</html>
