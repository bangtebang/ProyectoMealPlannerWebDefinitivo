<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    .form-container {
        background-color: rgba(255, 255, 255, 0.7);
        max-width: 400px;
        margin: 50px auto;
        padding: 20px;
        border-radius: 10px;
    }
    body {
        background-image: url(https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg);
        background-size: cover;
        background-repeat: no-repeat;}
</style>
<head>
    <title>Registro Valido</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<div class="form-container">
<h1 class="encabezado"> Registro usuario</h1>
<div class="centrado">
    <p class="subtitulo">Registro exitoso</p> <br>
    <label class="campoTexto"> Usuario : <c:out value="${usuario.getNombre()}"></c:out> </label>
    <br>
    <label class="campoTexto">Rut : <c:out value="${usuario.getRut()}"></c:out></label>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</div>
</html>