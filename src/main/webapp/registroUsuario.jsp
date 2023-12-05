
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<style>
    body {
        background-image: url(https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg);
        background-size: cover;
        background-repeat: no-repeat;
</style>
<head> <title>Registro usuario</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body>
<h1 class="encabezado">Registro usuario</h1>
<form action="registroUsuario" method="post">
    <div class="centrado">
        <label>Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">
        <label>Edad:</label>
        <input name="edad" type="number" class="campoTexto">
        <label>Rut:</label>
        <input name="rut" type="text" class="campoTexto">
        <br><br>
        <label>Sexo:</label>
        <input name="sexo" type="radio" value="M" class="campoTexto">Masculino
        <input name="sexo" type="radio" value="F" class="campoTexto">Femenino
        <br><br>
        <label>Peso(kg):</label>
        <input name="peso" type="number" class="campoTexto">
        <br>
        <label>Estatura(mts,cm):</label>
        <input name="estatura" type="number" class="campoTexto" step="0.01">
        <br><br>
        <label>Email:</label>
        <input name="email" type="email" class="campoTexto">
        <label>Telefono:</label>
        <input name="telefono" type="text" class="campoTexto">
        <br><br>
        <label>Direccion:</label>
        <input name="direccion" type="text" class="campoTexto">
        <br><br>
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
</body>
</html>