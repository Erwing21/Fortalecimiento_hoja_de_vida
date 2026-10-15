<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Error</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
  <header class="hero">
    <jsp:include page="/WEB-INF/menu.jsp" />
    <h1>Ocurrió un error</h1>
  </header>
  <main style="padding: 20px 10%;">
    <%
       // mensajeError lo envian los servlets; si no existe, el error lo reporto el contented
      String mensajeError = (String) request.getAttribute("mensajeError");
      int codigo = response.getStatus();
      String mensaje;
      if (mensajeError != null) {
        mensaje = mensajeError;
      } else if (codigo == 404) {
        mensaje = "La página que buscas no existe.";
      } else if (exception != null && exception.getMessage() != null) {
        mensaje = exception.getMessage().replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;");
      } else {
        mensaje = "Error no identificado";
      }
    %>
    <p><strong>Código:</strong> <%= codigo %></p>
    <p><%= mensaje %></p>
    <p><a href="<%= request.getContextPath() %>/index.html">Volver al inicio</a></p>
  </main>
</body>
</html>
