<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" session="false" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="x" uri="jakarta.tags.xml" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Demo JSTL: Core y XML</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles.css">
</head>
<body>
  <header class="hero hero-interno">
    <jsp:include page="/WEB-INF/menu.jsp" />
    <h1>Demo JSTL: Core y XML</h1>
    <p>Laboratorio de la Semana 14 con datos fijos.</p>
  </header>

  <main class="contenido">
    <section>
      <h2>Core: set, out y remove</h2>
      <div class="card">
        <%-- c:set crea variables, c:out las muestra y c:remove elimina una --%>
        <c:set var="titulo" value="JSTL - Hoja de vida" />
        <c:set var="aviso" value="Temporal" />
        <p>Título: <c:out value="${titulo}" /></p>
        <p>Aviso antes de remove: <c:out value="${aviso}" /></p>
        <c:remove var="aviso" />
        <p>Aviso después de remove: <c:out value="${aviso}" default="Eliminada" /></p>
      </div>

      <h2>XML: x:parse y x:out</h2>
      <div class="card">
        <%-- x:parse lee un XML fijo (de laboratorio); x:out consulta un nodo con XPath --%>
        <x:parse var="doc">
          <habilidad><nombre>Java</nombre><nivel>Básico</nivel></habilidad>
        </x:parse>
        <p>Habilidad: <x:out select="$doc/habilidad/nombre" /></p>
        <p>Nivel: <x:out select="$doc/habilidad/nivel" /></p>
      </div>
    </section>
  </main>

  <footer>
    <p>Proyecto de fortalecimiento de hoja de vida · Programacion III</p>
  </footer>
</body>
</html>