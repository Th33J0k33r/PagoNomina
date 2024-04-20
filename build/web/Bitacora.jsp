<%-- 
    Document   : bitacora
    Created on : 14 mar 2024, 20:41:27
    Author     : irism
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML5>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.*"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="misEstilos.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h1>Registros de Usuario</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                   <th>ID</th>
                    <th>NOMBRE</th>
                    <th>FECHA DE REGISTRO</th>
                    <th>HORA DE ENTRADA</th>
                    <th>HORA DE SALIDA</th>
                    <th>DIFERENCIA</th>

                </tr>
            </thead>
            
                <%
                    usuarioDAO dao = new usuarioDAO();
                    List<Usuario> list = dao.mostrar();
                    Iterator<Usuario>iter=list.iterator();
                    Usuario p=null;
                    while(iter.hasNext()){
                        p=iter.next();
                %>
                
                <tbody>
                    <tr>
                        <td><%= p.getIdempleado()%></td>
                        <td><%= p.getNombre()%></td>
                        <td><%= p.getFechaRegistro()%></td>
                        <td><%= p.getHoraDeEntrada()%></td>
                        <td><%= p.getHoraDeSalida()%></td>
                        <td><%= p.getDiferencia()%></td>
                    </tr>
                    <%}%>
                </tbody>
                
        </table>
                    
    </body>
</html>
