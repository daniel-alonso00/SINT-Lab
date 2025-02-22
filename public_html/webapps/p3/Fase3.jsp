<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <title>P3</title>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/p3/styles.css" %>">
</head>
<body>
    <h1>Servicio de información sobre peliculas</h1>

    <h3>Consulta 1: Fase3 (Cast = ${bean.pidC})</h3>
    <h3>Este es el resultado de la consulta:</h3>  

    <c:forEach items="${bean.movieList}" var="movie">
        <p>
            <b>Título = </b>${movie.title} 
            <b>--- Año = </b>${movie.year}
            <b> --- idM = </b>${movie.idM}
        </p>
    </c:forEach>
    <br>

    <!-- Botón para volver al inicio -->
    <form action="/sint2/P3M" method="get" class="botones">
        <input type="submit" value="Inicio" id="boton_inicio">
    </form>

    <!-- Botón para volver a la fase anterior -->
    <form action="/sint2/P3M" method="get" class="botones">
        <input type="hidden" name="pphase" value="2">
        <input type="hidden" name="plang" value="${bean.plang}">
        <input type="submit" value="Anterior" id="boton_anterior">
    </form>

    <hr>
    <footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>
</body>
</html>
