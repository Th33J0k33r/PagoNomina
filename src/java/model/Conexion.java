/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Th33J0k33r
 */
public class Conexion {
    private static Connection con;
    // Declaramos los datos de conexion a la bd
    private static final String driver="com.mysql.jdbc.Driver";
    private static final String user="root";
    private static final String pass="2013";
    private static final String url="jdbc:mysql://localhost:3306/dbnomina";
    private static String mensaje="";

    public static Connection getConexion()
	{
            if(con!=null)
            {
                    return con;
            }
            try
            {
                Class.forName(driver);
                con = DriverManager.getConnection(url, user, pass);
                mensaje = "Conectado a la base de datos";
                return con;
            }
            catch(ClassNotFoundException | SQLException ex)
            {
                mensaje = ex.getMessage();
                return null;
            }
	}
    
    public static String getMensaje(){
        return mensaje;
    }
    
    public static void cerrar(){
        try{
            con.close();
        }catch(SQLException ex){
            mensaje="Error al cerrar la conexion";
        }
    }
}