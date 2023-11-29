<%--
  Created by IntelliJ IDEA.
  User: esteb
  Date: 23-11-2023
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Catálogo de Productos</title>
    <style>
        .product {
            border: 1px solid #1f8377;
            padding: 10px;
            margin-bottom: 10px;
        }
        .product img {
            max-width: 100px;
            max-height: 100px;
            display: block;
            margin-bottom: 10px;
        }
        .product p {
            margin: 5px 0;
        }
        .buy-btn {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 5px 10px;
            cursor: pointer;
        }
        .buy-btn:hover {
            background-color: #0056b3;
        }

    </style>
</head>
<body>
<div id="product-list">

</div>

<script>
    const productos = [
        {
            nombre: "Producto 1",
            imagen: "https://via.placeholder.com/100",
            gramos: 150,
            calorias: 200,
            proteinas: 10,
            azucares: 5,
            sodio: 100
        },
        {
            nombre: "Producto 2",
            imagen: "https://via.placeholder.com/100",
            gramos: 200,
            calorias: 300,
            proteinas: 15,
            azucares: 8,
            sodio: 120
        },
        // Agrega más productos aquí con la misma estructura
        {
            nombre: "Producto 3",
            imagen: "https://via.placeholder.com/100",
            gramos: 120,
            calorias: 180,
            proteinas: 8,
            azucares: 4,
            sodio: 80
        },
        {
            nombre: "Producto 4",
            imagen: "https://via.placeholder.com/100",
            gramos: 250,
            calorias: 250,
            proteinas: 12,
            azucares: 6,
            sodio: 150
        }
    ];

    function mostrarProductos() {
        const productListContainer = document.getElementById('product-list');

        productos.forEach((producto) => {
            const productDiv = document.createElement('div');
            productDiv.classList.add('product');

            const imagen = document.createElement('img');
            imagen.src = producto.imagen;
            productDiv.appendChild(imagen);

            const nombreProducto = document.createElement('p');
            nombreProducto.textContent = `NOMBRE: ${producto.nombre}`;
            productDiv.appendChild(nombreProducto);

            const gramos = document.createElement('p');
            gramos.textContent = `GRAMOS: ${producto.gramos}`;
            productDiv.appendChild(gramos);

            const calorias = document.createElement('p');
            calorias.textContent = `CALORÍAS: ${producto.calorias}`;
            productDiv.appendChild(calorias);

            const proteinas = document.createElement('p');
            proteinas.textContent = `PROTEÍNAS: ${producto.proteinas}`;
            productDiv.appendChild(proteinas);

            const azucares = document.createElement('p');
            azucares.textContent = `AZÚCARES: ${producto.azucares}`;
            productDiv.appendChild(azucares);

            const sodio = document.createElement('p');
            sodio.textContent = `SODIO: ${producto.sodio}`;
            productDiv.appendChild(sodio);

            const comprarBtn = document.createElement('button');
            comprarBtn.classList.add('buy-btn');
            comprarBtn.textContent = 'Comprar';
            productDiv.appendChild(comprarBtn);

            productListContainer.appendChild(productDiv);
        });
    }

    mostrarProductos();
</script>
</body>
</html>