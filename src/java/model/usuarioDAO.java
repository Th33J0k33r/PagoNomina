/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDAO {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    Usuario u = new Usuario();
    
    public List mostrar(){
        ArrayList<Usuario>list=new ArrayList<>();
        String query = "select t2.idempleado, t2.nombre, t1.fecharegistro, t1.horaregistro, t1.horasalida, t1.diferencia from bitacora t1 " +
"inner join " +
"usuarios t2 " +
"on t1.idempleado=t2.idempleado;";
        
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                Usuario p = new Usuario();
                p.setIdempleado(rs.getString("idempleado"));
                p.setNombre(rs.getString("nombre"));
                p.setFechaRegistro(rs.getDate("fecharegistro"));
                p.setHoraDeEntrada(rs.getTime("horaregistro"));
                p.setHoraDeSalida(rs.getTime("horasalida"));
                p.setDiferencia(rs.getFloat("diferencia"));

                list.add(p);
            }
        } catch(SQLException e) {
            throw new RuntimeException("Fallo ",e);
        }
        return list;
    }

    public boolean add(Usuario p) {
        
        String SQL = "insert into bitacora (ID, Fecha, HoraDeEntrada, HoraDeSalida) values('"+p.getIdempleado()+"','"+p.getFechaRegistro()+"','"+p.getHoraDeEntrada()+"','"+p.getHoraDeSalida()+"')";

        try {
            
           con=cn.getConexion();
           ps=con.prepareStatement(SQL);
           ps.executeUpdate();
           ps.close();
        } catch (Exception e) {
            
        }
        String sql="select max(usersid) as iduser from users";
         int id=0;
         
         try{
             ps=con.prepareStatement(sql);
             rs=ps.executeQuery();
             if(rs.next()){
                 id= rs.getInt("iduser");
             }
             ps.close();
            rs.close();
         }catch(Exception e){
             
         }
        //double uIMC = p.calcularIMC();
        //SQL = "insert into bitacora (usersid, fecha_medicion, peso, imc) values('"+id+"', now(),'"+p.getPeso()+"','"+uIMC+"')";
        String a = "";
        a = "algo";
        try {
            
           ps=con.prepareStatement(SQL);
           ps.executeUpdate();
           ps.close();
           return true;
        } catch (Exception e) {
            
        }

        return false;
        
        
    } 
}