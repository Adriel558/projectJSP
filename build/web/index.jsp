<%-- 
    Document   : index
    Created on : 27/06/2024, 10:03:44 AM
    Author     : Thoms
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Desafio Practico JSP| Identificador de Figuras Geométricas</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f9;
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 100vh;
            }
            .container {
                background-color: white;
                padding: 20px;
                border-radius: 8px;
                box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                max-width: 400px;
                width: 100%;
            }
            h1 {
                text-align: center;
                color: #333;
            }
            label, input {
                display: block;
                width: 100%;
                margin-bottom: 10px;
            }
            input[type="text"] {
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
            }
            input[type="submit"] {
                background-color: #4CAF50;
                color: white;
                border: none;
                padding: 10px;
                border-radius: 4px;
                cursor: pointer;
                width: 100%;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <div class="container">
        <h1>Ingresar Valores de la Figura</h1>
        <form action="ProcessFigureServlet" method="post">
            <label for="side1">Lado 1/Radio:</label>
            <input type="text" id="side1" name="side1"><br>
            <label for="side2">Lado 2:</label>
            <input type="text" id="side2" name="side2"><br>
            <label for="side3">Lado 3:</label>
            <input type="text" id="side3" name="side3"><br>
            <label for="side4">Lado 4:</label>
            <input type="text" id="side4" name="side4"><br>
            <input type="submit" value="Procesar">
        </form>
    </div>
</body>
</html>
