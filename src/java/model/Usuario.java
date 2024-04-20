/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Usuario {

    private String idempleado;
    private String nombre;
    private String usuario;
    private String password;
    private Date fechaRegistro;
    private Date HoraDeEntrada;
    private Date HoraDeSalida;
    
    /*
    private Date FechaDeRegistro = new Date();
    SimpleDateFormat fechaRegistro = new SimpleDateFormat("yyyy-MM-dd");
    private Date HoraDeEntrada;
    SimpleDateFormat horaEntrada = new SimpleDateFormat("HH:mm:ss");
    private Date HoraDeSalida;
    SimpleDateFormat horaSalida = new SimpleDateFormat("HH:mm:ss");
*/
    private String TipoDeRegistro;

    private float diferencia;

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public float getDiferencia() {
        return diferencia;
    }

    public void setDiferencia(float diferencia) {
        this.diferencia = diferencia;
    }

    public String getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(String idempleado) {
        this.idempleado = idempleado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getPassword() {
        return password;
    }
   
    public Date getHoraDeEntrada() {
        return HoraDeEntrada;
    }

   
    public Date getHoraDeSalida() {
        return HoraDeSalida;
    }

    public String getTipoDeRegistro() {
        return TipoDeRegistro;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public void setHoraDeEntrada(Date HoraDeEntrada) {
        this.HoraDeEntrada = HoraDeEntrada;
    }

   
    public void setHoraDeSalida(Date HoraDeSalida) {
        this.HoraDeSalida = HoraDeSalida;
    }
   

    public void setTipoDeRegistro(String TipoDeRegistro) {
        this.TipoDeRegistro = TipoDeRegistro;
    }

}