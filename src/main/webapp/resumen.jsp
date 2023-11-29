<%--
  Created by IntelliJ IDEA.
  User: esteb
  Date: 23-11-2023
  Time: 23:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Resumen Semanal de Comidas</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-image: url('https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg'); /* URL de la imagen */
      background-size: cover;
      background-repeat: no-repeat;
      background-attachment: fixed;
    }
    h1 {
      text-align: center;
      color: #000000;
    }
    .summary {
      border: 1px solid #ccc;
      padding: 10px;
      margin: 20px auto;
      width: 70%;
      background-color: rgba(255, 255, 255, 0.8);
    }
    .day-summary {
      margin-bottom: 20px;
    }
    .day {
      font-weight: bold;
    }
    .meal {
      margin-bottom: 10px;
      color: black;
    }
    .meal p {
      margin: 5px 0;
    }
    .total {
      font-weight: bold;
      margin-top: 10px;
    }
  </style>
</head>
<body>
<h1>Resumen Semanal de Comidas</h1>

<div class="summary">
  <div class="day-summary">
    <h2 class="day">Lunes</h2>
    <div class="meal">
      <p>Desayuno:</p>
      <p>1 huevo, 2 rebanadas de pan integral, 1 vaso de jugo de naranja</p>
    </div>
    <div class="meal">
      <p>Almuerzo:</p>
      <p>Ensalada de pollo, arroz integral, verduras al vapor</p>
    </div>
    <div class="meal">
      <p>Cena:</p>
      <p>Pescado a la parrilla, puré de papas, brócoli</p>
    </div>
    <p class="total">Total del lunes:</p>
    <p>Gramos: 1200, Calorías: 1500, Proteínas: 80g, Azúcares: 30g, Sodio: 2000mg</p>
  </div>


  <div class="total">
    <h2>Resumen Semanal</h2>
    <p>Total Semanal: Gramos: 6000, Calorías: 7200, Proteínas: 400g, Azúcares: 120g, Sodio: 10000mg</p>
  </div>
</div>

</body>
</html>