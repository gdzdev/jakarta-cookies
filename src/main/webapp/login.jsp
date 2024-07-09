<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" type="text/css" href="styles/styles.css">
</head>
    <body>
    <form action="/webapp-cookies/login" method="POST">
    <h1>Iniciar Sesion</h1>
        <div>
            <label for="username">UserName</label>
            <div>
                <input type="text" name="username" id="username">
            </div>
        </div>
        <div>
            <label for="password">Password</label>
            <div>
                <input type="password" name="password" id="password">
            </div>
        </div>
        <div>
            <input type="submit" value="Login">
        </div>
    </form>
    </body>
</html>