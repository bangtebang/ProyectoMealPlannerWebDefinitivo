<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>Registro Alimento</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body> <h1 class="encabezado">Registro alimento</h1>
<form action="registroAlimento" method="post">
    <div class="centrado">
        <label>Nombre:</label>
        <input type="text" name="nombre" required>
        <br>
        <label>Calorias:</label>
        <input type="number" name="calorias" required>
        <br>
        <label>Proteinas:</label>
        <input type="number" name="proteinas" required>
        <br>
        <label>Carbohidratos:</label>
        <input type="number" name="carbohidratos" required>
        <br>
        <label>Azúcares:</label>
        <input type="number" name="azucares" required>
        <br>
        <label>Sodio:</label>
        <input type="number" name="sodio" required>
        <br>
        <label>Fibra:</label>
        <input type="number" name="fibra" required>
        <br>
        <label>Vegetariano:</label>
        <input type="checkbox" name="vegetariano">
        <br>
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
</body>
</html>
