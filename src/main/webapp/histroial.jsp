<%--
  Created by IntelliJ IDEA.
  User: esteb
  Date: 23-11-2023
  Time: 23:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Historial</title>
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
<h1>Resumenes semanales pasados</h1>

<div class="summary">
  <div class="week-summary">
    <h2>Semana del 10 al 17 de Octubre</h2>
    <p>Total Semanal: Gramos: 6000, Calorías: 7200, Proteínas: 400g, Azúcares: 120g, Sodio: 10000mg</p>
  </div>
</div>

</body>
</html>