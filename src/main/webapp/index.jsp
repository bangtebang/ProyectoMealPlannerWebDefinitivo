<!DOCTYPE html>
<html lang="en-US">
<head>
    <title>MealPlannerWeb</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <style>
        .navbar {
            overflow: hidden;
            background-color: #962828;
        }

        .navbar a {
            float: left;
            display: block;
            color: black;
            text-align: center;
            padding: 14px 16px;
            text-decoration: none;
            font-size: 17px;
        }

        .navbar a:hover {
            background-color: #ddd;
            color: black;
        }

        .search-container {
            float: right;
            margin-top: 8px;
        }

        .search-container input[type="text"] {
            padding: 6px;
            font-size: 17px;
            border: none;
            margin-right: 4px;
        }

        .search-container button {
            padding: 6px 10px;
            background: #ddd;
            font-size: 17px;
            border: none;
            cursor: pointer;
            margin-right: 16px;
        }

        .search-container button:hover {
            background: #ccc;
        }


        .content {
            display: flex;
            justify-content: space-between;
            margin-top: 20px;
        }

        .col {
            width: 48%;
            margin-bottom: 20px;
        }

        .col a {
            text-decoration: none;
            color: black;
        }

        .col h2 {
            margin-top: 20px;
        }

        .col p {
            font-size: 16px;
        }

        .bg-red {
            background-color: #cf2e2e;
        }

        .bg-blue {
            background-color: #0693e3;
        }

        .half-container-left,
        .half-container-right {
            padding: 20px;
            text-align: center;
            color: white;
        }

        .half-container-left img,
        .half-container-right img {
            width: 50px;
            height: 50px;
        }
        .intro {
            display: flex;
            align-items: center;
            justify-content: center;
            height: 600px;
            background-image: url(https://img.freepik.com/fotos-premium/mantel-cocina-cuadros-rojos-blancos-sobre-mesa-madera_887552-21108.jpg);
            background-size: cover;
            background-position: center;
            color: black;
            text-align: center;
        }

        .intro h1 {
            margin-top: 0;
        }
    </style>
</head>
<body>

<div class="navbar">
    <a href="usuario.jsp">Mi Perfil</a>
    <a href="registroUsuario.jsp">Registrar Usuario</a>
    <a href="catalogo.jsp">Catalogo de alimentos</a>
    <div class="search-container">
        <form action="/search" method="GET">
            <input type="text" placeholder="Buscar..." name="search">
            <button type="submit">Buscar</button>
        </form>
    </div>
</div>
<div class="intro">
    <div class="intro__content" style="display: flex; align-items: center;">
        <div style="margin-right: 20px; display: flex; justify-content: center; align-items: center;">
            <img src="data:image/jpeg;base64,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" alt="Imagen" style="border-radius: 50%; width: 200px; height: 200px;">
        </div>
        <div style="text-align: left;">
            <h1>
                <small style="display: block; font-size: 1.5rem; margin-bottom: 10px;">PLANEA TU SEMANA</small>
                <span style="display: block; font-size: 3rem; line-height: 1.2;">
                    Organiza todas tus<br>comidas semana a semana<br>y realiza un resumen detallado de lo consumido.
                </span>
            </h1>
        </div>
    </div>
</div>
</div>
<div class="content">
    <div class="col width1-2 bg-red">
        <div class="half-container-left">
            <a href="historial.jsp">
                <img src="https://pinkpointmedia.com/wp-content/uploads/2015/01/portfolio-icon.svg" alt="">
                <h2>Historial</h2>
                <p>Revisa tus planes de semanas anteriores.</p>
            </a>
        </div>
    </div>

    <div class="col width1-2 bg-blue">
        <div class="half-container-right">
            <a href="resumen.jsp">
                <img src="https://pinkpointmedia.com/wp-content/uploads/2015/01/results-icon.svg" alt="">
                <h2>Resumen Semanal</h2>
                <p>Revisa el resumen detallado de lo que has consumido esta semana.</p>
            </a>
        </div>
    </div>
</div>

</body>
</html>
</html>