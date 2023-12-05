<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alimento Consumido</title>
    <style>
        body {
            background-image: url(https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg);
            background-size: cover;
            background-repeat: no-repeat;
            margin: 0;
            font-family: Arial, sans-serif;
        }

        .form-container {
            background-color: rgba(255, 255, 255, 0.7);
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            border-radius: 10px;
            text-align: center; /* Centrar todos los elementos */
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        .campoTexto {
            width: 100%; /* Ancho del 100% para ocupar todo el contenedor */
            box-sizing: border-box; /* Incluye el padding en el ancho */
            padding: 8px;
            margin-bottom: 12px;
            font-size: 16px;
        }

        .boton {
            padding: 10px 24px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .boton:hover {
            background-color: #0056b3;
        }

        .encabezado {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1 class="encabezado">Registro alimento consumido</h1>
    <form id="formulario" action="asociarAlimentoUsuario" method="post">
        <label>Nombre del alimento consumido:</label>
        <input type="text" name="nombre" class="campoTexto">
        <br>
        <label>RUT del usuario que lo consumió:</label>
        <input type="text" name="rut" class="campoTexto">
        <br>
        <input type="hidden" name="fecha" id="fecha">
        <br>
        <input type="submit" value="Enviar" class="boton">
    </form>
</div>

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