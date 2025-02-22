<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>P3</title>
    <link rel="stylesheet" href="<%= request.getContextPath() + "/p3/styles.css" %>">
</head>
<body>
    <h1>Servicio de información sobre peliculas</h1>
    <h1>Bienvenido a este servicio</h1>

    <p><b>Nombre de fichero procesado: </b>${bean.nombreFichero}</p>
    <p><b>IP del cliente: </b>${bean.ipCliente}</p>
    <p><b>Información del navegador: </b>${bean.infoNavegador}</p>

    <h3>Selecciona una consulta:</h3>
    <ul type="square">
        <li><a href="P3M?pphase=1">Consulta 1: Peliculas de actor/actriz con peliculas en un idioma</a></li>
    </ul>

    <hr>
    <footer>&copy; Daniel Alonso Fernandez (2024-2025)</footer>
</body>
</html>
