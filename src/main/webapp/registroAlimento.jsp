<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head> <title>Registro Alimento</title>
    <link rel="stylesheet" type="text/css" href="styles.css">
</head>
<body> <h1 class="encabezado">Registro alimento</h1>
<form action="registroAlimento" method="post">
    <div class="centrado">
        <label>Nombre:</label>
        <input type="text" name="nombre" class="campoTexto">
        <br>
        <label>Calorias:</label>
        <input type="number" name="calorias" class="campoTexto" step="0.01">
        <br>
        <label>Gramos:</label>
        <input type="number" name="gramos" class="campoTexto" step="0.01">
        <br>
        <label>Proteinas:</label>
        <input type="number" name="proteinas" class="campoTexto" step="0.01" >
        <br>
        <label>Carbohidratos:</label>
        <input type="number" name="hidratosDeCarbono"  class="campoTexto" step="0.01">
        <br>
        <label>Azúcares:</label>
        <input type="number" name="azucares" class="campoTexto" step="0.01">
        <br>
        <label>Sodio:</label>
        <input type="number" name="sodio" class="campoTexto" step="0.01">
        <br>
        <label>Fibra:</label>
        <input type="number" name="fibra" class="campoTexto" step="0.01">
        <br>
        <label>Vegetariano:</label>
        <input type="checkbox" name="vegetariano">
        <br>
        <input type="submit" value="enviar" class="boton">
    </div>
</form>
</body>
</html>
