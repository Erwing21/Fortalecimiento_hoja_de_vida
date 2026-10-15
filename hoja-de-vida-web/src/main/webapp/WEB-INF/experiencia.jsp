<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%-- Declaracion: metodo de la pagina para que un texto escrito por el usuario no se interprete como HTML --%>
<%!
  String limpiar(String texto) {
    return texto.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;");
  }
%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Experiencia registrada</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
  <header class="hero">
    <jsp:include page="/WEB-INF/menu.jsp" />
    <h1>Experiencia registrada</h1>
  </header>
  <main style="padding: 20px 10%;">
    <p>Puesto: <%= limpiar((String) request.getAttribute("puesto")) %></p>
    <p>Empresa: <%= limpiar((String) request.getAttribute("empresa")) %></p>
    <p>Duración: <%= limpiar((String) request.getAttribute("duracion")) %></p>
    <p><a href="<%= request.getContextPath() %>/Experiencia.html">Registrar otra</a></p>
  </main>
</body>
</html>
