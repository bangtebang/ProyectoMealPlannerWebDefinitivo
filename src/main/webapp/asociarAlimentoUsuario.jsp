<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>Alimento Consumido</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body> <h1 class="encabezado">Registro alimento consumido</h1>
<form id="formulario" action="asociarAlimentoUsuario" method="post">
    <div class="centrado">
        <label>Nombre del alimento consumido:</label>
        <input type="text" name="nombre" class="campoTexto">
        <br>
        <label>rut del usuario que lo consumio:</label>
        <input type="text" name="rut" class="campoTexto">
        <br>
        <input type="hidden" name="fecha" id="fecha">
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
<script>
    var formulario = document.getElementById("formulario");
    formulario.addEventListener("submit", function(event) {
        var inputFecha = document.getElementById("fecha");
        var fechaActual = new Date();
        inputFecha.value = fechaActual.getFullYear() + "-" + (fechaActual.getMonth() + 1) + "-" + fechaActual.getDate() + " " + fechaActual.getHours() + ":" + fechaActual.getMinutes() + ":" + fechaActual.getSeconds();
    });
</script>
</body>
</html>