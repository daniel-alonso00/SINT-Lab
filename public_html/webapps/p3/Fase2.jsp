<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>P3</title>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/p3/styles.css" %>">
</head>
<body>
    <h1>Servicio de información sobre peliculas</h1>

    <h3>Consulta 2: Fase2 (Idioma = ${bean.plang})</h3>
    <h3>Selecciona un actor/actriz:</h3>

    <c:forEach items="${bean.castList}" var="cast">
            <a href="P3M?pphase=3&plang=${bean.plang}&pidC=${cast.idC}">
                Nombre = ${cast.name} --- idC = ${cast.idC}
            </a><br>
    </c:forEach>
    <br>

    <!-- Botón para regresar al inicio -->
    <form action="/sint2/P3M" method="get" class="botones">
        <input type="submit" value="Inicio" id="boton_inicio">
    </form>

    <!-- Botón para regresar a la fase anterior -->
    <form action="/sint2/P3M" method="get" class="botones">
        <input type="hidden" name="pphase" value="1">
        <input type="submit" value="Anterior" id="boton_anterior">
    </form>

    <hr>
    <footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>
</body>
</html>
