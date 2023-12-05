<!DOCTYPE html>
<html>
<head>
    <title>Registro usuario</title>
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
        }

        label {
            display: block;
            margin-bottom: 8px;
        }

        .campoTexto {
            width: calc(100% - 24px);
            padding: 8px;
            margin-bottom: 12px;
            font-size: 16px;
        }

        .radio-container {
            display: flex;
            align-items: center;
        }

        .radio-container input[type="radio"] {
            margin-right: 8px;
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
            text-align: center;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="form-container">
    <h1 class="encabezado">Registro usuario</h1>
    <form action="registroUsuario" method="post">
        <label>Nombre:</label>
        <input name="nombre" type="text" class="campoTexto">

        <label>Edad:</label>
        <input name="edad" type="number" class="campoTexto">

        <label>Rut:</label>
        <input name="rut" type="text" class="campoTexto">
        <label>Sexo:</label>
        <div class="radio-container">
            <input name="sexo" type="radio" value="M" class="campoTexto"><span>Masculino</span>
            <input name="sexo" type="radio" value="F" class="campoTexto"><span>Femenino</span>
        </div>

        <label>Peso:</label>
        <input name="peso" type="number" class="campoTexto">

        <label>Estatura:</label>
        <input name="estatura" type="number" class="campoTexto" step="0.01" >

        <label>email:</label>
        <input name="email" type="email" class="campoTexto">

        <label>telefono:</label>
        <input name="telefono" type="text" class="campoTexto">

        <label>direccion:</label>
        <input name="direccion" type="text" class="campoTexto">

        <input type="submit" value="Enviar" class="boton">
    </form>
</div>
</body>
</html>