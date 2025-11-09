//gestion de paquetes
package com.espol.modelo;

//importacion de librerias
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class ControlDeHidratacion {

    //variables
    private int cantidadAguaIngerida;
    private int aguaAcumulada;
    private int metaDeHidratacion = 2500;
    private LocalDate fecha = LocalDate.now(); 
    private LocalTime hora;
    private List<String> horasRegistradas = new ArrayList<>();

    //metodos

    //constructorres
    public ControlDeHidratacion(){

    }

    public void sumarAguaAcumulada(int agua){
        this.aguaAcumulada += agua;
    }

    private void verificarCambioDeDia() {
        LocalDate hoy = LocalDate.now();
        if (!hoy.equals(this.fecha)) {
            this.fecha = hoy;
            this.cantidadAguaIngerida = 0;  // Reinicia la cantidad del nuevo día
            this.horasRegistradas.clear();  // Limpia las horas del día anterior
        }
    }
    

    //getters
    public int getCantidadAguaIngerida(){
        return cantidadAguaIngerida;
    }
    public int getAguaAcumulada(){
        return aguaAcumulada;
    }
    public int getMetaDeHidratacion(){
        return metaDeHidratacion;
    }
    public LocalDate getFecha() {
        return fecha; 
    }
    public List<String> getHorasRegistradas() { 
        return horasRegistradas; 
    }
    //setters

    //Cada vez que se ingresa cantidad de agua digerida, se obtiene la fecha y hora del registro
    public void setCantidadAguaIngerida(int cantidadAguaIngerida){
        verificarCambioDeDia();
        
        this.cantidadAguaIngerida = cantidadAguaIngerida;
        this.hora = LocalTime.now(); //Hora exacta
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("hh:mm a");

        horasRegistradas.add(hora.format(formatoHora));
    }

    public void setMetaDeHidratacion(int metaDeHidratacion){
        this.metaDeHidratacion = metaDeHidratacion;
        
    }

    public void setCantidadAguaIngerida(int cantidadAguaIngerida, LocalTime hora){
        verificarCambioDeDia();
        
        this.cantidadAguaIngerida = cantidadAguaIngerida;
        this.hora = hora; //Hora personalizada
        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("hh:mm a");

        horasRegistradas.add(hora.format(formatoHora));
    }

}





    


