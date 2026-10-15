<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Consejo del día</title>
  <link rel="stylesheet" href="<%= request.getContextPath() %>/styles.css">
</head>
<body>
  <header class="hero">
    <jsp:include page="/WEB-INF/menu.jsp" />
    <h1>Consejo del día</h1>
  </header>
  <main style="padding: 20px 10%;">
    <%-- El consejo lo prepara ConsejoServlet; la JSP solo lo muestra --%>
    <p><%= request.getAttribute("consejo") %></p>
    <p><a href="<%= request.getContextPath() %>/consejo">Ver otro consejo</a></p>
  </main>
</body>
</html>
