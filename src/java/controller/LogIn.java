/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Conexion;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author irism
 */
@WebServlet(name = "LogIn", urlPatterns = {"/LogIn"})
public class LogIn extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String usuario = request.getParameter("user");
            String password = request.getParameter("password");

            String consulta = "select * from usuarios where usuario = ? and password = ?";

            PreparedStatement ps;
            ResultSet rs;

            Connection con = Conexion.getConexion();

            try {
                ps = con.prepareStatement(consulta);
                ps.setString(1, usuario);
                ps.setString(2, password);
                rs = ps.executeQuery();

                if (rs.next()) {
                    //out.print("Acceso concedido");
                    response.sendRedirect("Bitacora.jsp");
                } else {
                    //response.sendRedirect("index.jsp");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                }

                ps.close();
                rs.close();

            } catch (SQLException e) {
                
                System.out.println("Mensaje de la excepción: " + e.getMessage());
                e.printStackTrace();
                // Manejar el error apropiadamente
                //out.println("<html><body>");
                //out.println("<h2>Error al obtener datos del usuario</h2>");
                //out.println("</body></html>");

            }
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
        processRequest(request, response);
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
        processRequest(request, response);
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
