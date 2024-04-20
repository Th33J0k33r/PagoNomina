<%-- 
    Document   : index
    Created on : 14 abr 2024, 22:27:25
    Author     : Th33J0k33r
--%>

<%@page import="controller.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <H1>Bienvenido</H1>
        <form action="Logica" method="post">

            <input type="text" id="NoEmpleado" name="NoEmpleado" placeholder="No. Empleado" maxlength="15" required><br><br>

            <Label> 
                <input type="checkbox" name="opcion" value="Entrada" onclick="handleCheckbox(this)">
                Entrada
            </Label>
            <Label> 
                <input type="checkbox" name="opcion" value="Salida" onclick="handleCheckbox(this)">
                Salida
            </Label>
            <br><br>
            <input type="submit" name="accion" value="Agregar" />
        </form>
        <script>
            function handleCheckbox(checkbox) {
                var checkboxes = document.getElementsByName('opcion');
                for (var i = 0; i < checkboxes.length; i++) {
                    if (checkboxes[i] !== checkbox) {
                        checkboxes[i].checked = false;
                    }
                }
            }           
        </script>
    </body>
</html>
