<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<style>
    body {
        background-image: url(https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg);
        background-size: cover;
        background-repeat: no-repeat;}
</style>
<head>
    <title>Registro Valido</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<h1 class="encabezado"> Registro Alimento</h1>
<div class="centrado">
    <p class="subtitulo">Registro exitoso</p> <br>
    <label class="campoTexto"> Nombre : <c:out value="${alimento.getNombre()}"></c:out> </label>
    <br>
    <label class="campoTexto">fecha: <c:out value="${alimento.getFecha()}"></c:out></label>
    <a class="boton" href="index.jsp">Volver</a>
</div>
</html>
