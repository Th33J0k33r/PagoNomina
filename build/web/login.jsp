<%-- 
    Document   : login
    Created on : 14 abr 2024, 10:24:45
    Author     : Th33J0k33r
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Evidencia Final - IMC</title>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
            <h1>Bienvenido</h1>
            <form action="LogIn" method="post">
                <input type="text" id="user" name="user" placeholder="Usuario" maxlength="15" required><br><br>
                <input type="password" id="password" name="password" placeholder="Password" maxlength="15" required/><br><br>
                <div>
                    <a href="registroInicial.jsp">Registrate</a>
                    <span class="input-group-addon"></span>
                    <input type="submit" value="Ingresar" style="width: 100px; height: 30px;"/>
                </div>
            </form>
    </body>
</html>