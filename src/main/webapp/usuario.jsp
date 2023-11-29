<%--
  Created by IntelliJ IDEA.
  User: esteb
  Date: 22-11-2023
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Información de Usuario</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            font-family: Arial, sans-serif;
            background: url(https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg) no-repeat center center fixed; /* Reemplaza 'URL_DE_LA_IMAGEN' con la URL de tu imagen */
            background-size: cover;
        }
        .form-container {
            width: 70%;
            margin: auto;
            padding: 20px;
            border: 1px solid #85c7b6;
            border-radius: 10px;
            background-color: rgba(255, 255, 255, 0.8);
        }
        .form-container h2 {
            text-align: center;
        }
        .form-group {
            margin-bottom: 15px;
            padding: 8px;
            border-radius: 5px;
            display: flex;
            align-items: center;
        }
        .form-group label {
            font-weight: bold;
            margin-right: 10px;
            flex: 1;
        }
        .form-group .data-container {
            flex: 2;
            padding: 8px;
            border: 1px solid #c76b6b;
            border-radius: 5px;
            background-color: #ffffff;
        }
        .form-group img {
            display: block;
            margin: 0 auto;
            width: 200px;
            height: 200px;
            border-radius: 50%;
            object-fit: cover;
        }
        .form-group button {
            width: 50%;
            padding: 6px;
            border: none;
            border-radius: 3px;
            background-color: #007bff;
            color: white;
            cursor: pointer;
            margin: 0 auto;
            display: block;
        }
        .form-group button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Información de Usuario</h2>
    <form>
        <div class="form-group">
            <img src="data:image/jpeg;base64,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" alt="Imagen de perfil">
        </div>
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <div class="data-container">Luke Danes </div>
        </div>
        <div class="form-group">
            <label for="edad">Edad:</label>
            <div class="data-container">38</div>
        </div>
        <div class="form-group">
            <label for="peso">Peso:</label>
            <div class="data-container">70</div>
        </div>
        <div class="form-group">
            <label for="altura">Altura:</label>
            <div class="data-container">180</div>
        </div>
        <div class="form-group">
            <label for="email">Correo:</label>
            <div class="data-container">lukes@gmail.com</div>
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <div class="data-container">+56981273645</div>
        </div>
        <div class="form-group">
            <label for="direccion">Dirección:</label>
            <div class="data-container">Calle A 1254</div>
        </div>
        <div class="form-group">
            <button type="button" onclick="window.history.back()" style="border: none;">Regresar</button>
        </div>
    </form>
</div>

</body>
</html>