<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Cambiar color del texto</title>
</head>
    <body>
        <h3 style="color: ${cookie.color.getValue()}">Tarea 4: cambiar color de los textos</h3>
        <p style="color: ${cookie.color.getValue()}">Hola este es un text que cambia de color que elijas en las opciones</p>

        <form action="/webapp-cookies/cambiar-color" method="GET">
            <label for="color">Cambiar color</label>
            <div>
                <select name="color" id="color">
                    <option value="blue">blue</option>
                    <option value="red">red</option>
                    <option value="green">green</option>
                    <option value="aqua">aqua</option>
                    <option value="BlueViolet">blueViolet</option>
                    <option value="Gray">gray</option>
                    <option value="Cyan">cyan</option>
                </select>
            </div>
            <div>
                <input type="submit" value="Cambiar">
            </div>
        </form>
    </body>
</html>