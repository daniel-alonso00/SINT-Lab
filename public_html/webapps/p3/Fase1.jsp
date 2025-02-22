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
    <h3>Consulta 1: Fase1</h3>
    <h3>Selecciona un idioma:</h3>

    <c:forEach items="${bean.langs}" var="idioma">
            <a href="P3M?pphase=2&plang=${idioma}">${idioma}</a><br>
    </c:forEach>

    <br>
    
    <!-- Formulario para regresar al inicio -->
    <form action="/sint/P3M" method="get" class="botones">
        <input type="submit" value="Inicio" id="boton_inicio">
    </form>

    <hr>
    <footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>
</body>
</html>
