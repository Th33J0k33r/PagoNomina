<%-- 
    Document   : index
    Created on : 14 abr 2024, 22:27:25
    Author     : Th33J0k33r
--%>

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
        <form action="LogIn" method="post">
                
                <input type="text" id="NoEmpleado" name="NoEmpleado" placeholder="No. Empleado" maxlength="15" required><br><br>
                <button type="button" onclick="SendData()">Enviar</button>
                <Label> 
                    <input type="checkbox" name="opcion" value="Entrada" onclick="handleCheckbox(this)">
                    Entrada
                </Label>
                <Label> 
                    <input type="checkbox" name="opcion" value="Salida" onclick="handleCheckbox(this)">
                    Salida
                </Label>
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
            function sendData() {
                var checkboxes = document.getElementsByName('opcion');
                var selectedOption = '';

                for (var i = 0; i < checkboxes.length; i++) {
                  if (checkboxes[i].checked) {
                    selectedOption = checkboxes[i].value;
                    break;
                  }
                }

                var info = document.getElementById('NoEmpleado').value;


                var xhr = new XMLHttpRequest();
                xhr.open('POST', 'Logica', true);
                xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

                xhr.send('opcion=' + encodeURIComponent(selectedOption) + '&NoEmpleado=' + encodeURIComponent(info));
              }
            
        </script>
        
    </body>
</html>
