
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
    <title>Registro Incorrecto</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<div class="form-container">
<h1 class="encabezado">Registro invalido</h1>
<h2 class="subtitulo">Datos Incorrectos,favor comprobar nuevamente</h2>
<form action="registroEvento" method="post">
    <div class="centrado">
        <a class="boton" href="index.jsp">Volver</a>
    </div>
</form>
</div>
</body>
</html>
