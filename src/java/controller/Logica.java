/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import model.*;

/**
 *
 * @author Sistemas
 */
public class Logica extends HttpServlet {

    String add = "login.jsp";

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    Usuario u = new Usuario();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Establecer el tipo de contenido de la respuesta
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String acceso = "";
        // Obtener la fecha y la hora actual
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fecha = ahora.format(formatterFecha);
        String hora = ahora.format(formatterHora);
        String horaRegistro = "";

        // Obtener los parámetros enviados desde el formulario
        String noEmpleado = request.getParameter("NoEmpleado");
        String opcion = request.getParameter("opcion");
        String action = request.getParameter("accion");

        String query = "";
        int id = 0;

        if (opcion.equalsIgnoreCase("Entrada")) {

            //Ya debemos tener usuarios previamente registrados, necesitamos una consulta para traer esta informacion (nombre e identificador)
            try {
                query = "select * from usuarios where idempleado=?";

                try {
                    con = cn.getConexion();
                    ps = con.prepareStatement(query);
                    ps.setString(1, noEmpleado);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        u.setIdempleado(rs.getString("idempleado"));
                    }
                    ps.close();
                    rs.close();

                } catch (SQLException e) {

                }

            } catch (Exception e) {
                e.printStackTrace();
                // Manejar el error apropiadamente
                out.println("<html><body>");
                out.println("<h2>Error al obtener datos del usuario</h2>");
                out.println("</body></html>");
            }

            try {
                query = "INSERT INTO bitacora (idempleado, tiporegistro, fecharegistro, horaregistro) VALUES ('" + u.getIdempleado() + "','" + 1 + "','" + fecha + "','" + hora + "')";
                ps = con.prepareStatement(query);

                // Ejecutar la consulta
                int filasInsertadas = ps.executeUpdate();

                if (filasInsertadas > 0) {
                    out.println("<html><body>");
                    out.println("<h2>Registro correcto</h2>");
                    out.println("</body></html>");
                } else {
                    // Mostrar un mensaje de error si no se insertaron filas
                    out.println("<html><body>");
                    out.println("<h2>Error al registrar usuario</h2>");
                    out.println("</body></html>");
                }
                ps.close();
                rs.close();

            } catch (SQLException e) {
                e.printStackTrace();
                // Manejar el error apropiadamente
                out.println("<html><body>");
                out.println("<h2>Error al registrar usuario</h2>");
                out.println("</body></html>");
            }
            acceso = add;
        }

        if (opcion.equalsIgnoreCase("Salida")) {
            //Ya debemos tener usuarios previamente registrados, necesitamos una consulta para traer esta informacion (nombre e identificador)
            try {
                query = "select * from usuarios where idempleado=?";

                try {
                    con = cn.getConexion();
                    ps = con.prepareStatement(query);
                    ps.setString(1, noEmpleado);
                    rs = ps.executeQuery();

                    while (rs.next()) {
                        u.setIdempleado(rs.getString("idempleado"));
                    }
                    ps.close();
                    rs.close();
                } catch (SQLException e) {

                }

            } catch (Exception e) {
                e.printStackTrace();
                // Manejar el error apropiadamente
                out.println("<html><body>");
                out.println("<h2>Error al obtener datos del usuario</h2>");
                out.println("</body></html>");
            }

            //Consultamos la hora de entrada
            try {

                query = "select * from bitacora where idempleado=? and fecharegistro=?";

                con = cn.getConexion();
                ps = con.prepareStatement(query);
                ps.setString(1, noEmpleado);
                ps.setString(2, fecha);
                rs = ps.executeQuery();

                while (rs.next()) {
                    //u.setIdempleado(rs.getString("idempleado"));
                    horaRegistro = rs.getString("horaregistro");
                }
                ps.close();
                rs.close();

            } catch (Exception e) {
                e.printStackTrace();
                // Manejar el error apropiadamente
                out.println("<html><body>");
                out.println("<h2>Error al obtener datos del usuario</h2>");
                out.println("</body></html>");
            }

            try {
                // Define un formato para convertir las cadenas a LocalTime
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                // Convierte las cadenas a LocalTime
                LocalTime horaEntrada = LocalTime.parse(horaRegistro, formatter);
                LocalTime horaSalida = LocalTime.parse(hora, formatter);
                // Calcula la diferencia de horas
                long horasDiferencia = ChronoUnit.HOURS.between(horaEntrada, horaSalida);

                //query = "INSERT INTO bitacora (idempleado, tiporegistro, fecharegistro, horaregistro) VALUES ('" + u.getIdempleado() + "','" + 2 + "','" + fecha + "','" + hora + "')";
                query = "UPDATE bitacora SET horasalida = '" + hora + "', diferencia = '" + horasDiferencia + "' WHERE idempleado = '" + u.getIdempleado() + "' AND fecharegistro = '" + fecha + "'";
                ps = con.prepareStatement(query);

                // Ejecutar la consulta
                int rowsUpdated = ps.executeUpdate();

                if (rowsUpdated > 0) {
                    out.println("<html><body>");
                    out.println("<h2>Registro correcto</h2>");
                    out.println("</body></html>");
                } else {
                    // Mostrar un mensaje de error si no se insertaron filas
                    out.println("<html><body>");
                    out.println("<h2>Error al registrar usuario</h2>");
                    out.println("</body></html>");
                }
                ps.close();
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
                // Manejar el error apropiadamente
                out.println("<html><body>");
                out.println("<h2>Error al registrar usuario</h2>");
                out.println("</body></html>");
            }

            acceso = add;
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
