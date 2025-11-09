package com.espol.modelo;
import java.time.LocalDateTime;
public class ActividadPersonal extends Actividad{
protected String lugar;
//Herencia donde se llaman 2 constructores diferentes, para poder colocar los valores iniciales.
public ActividadPersonal( int id,String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo, String lugar){

super(id, nombre, descripcion, fechaVencimiento,prioridad, tiempoEstimado, avance, tipo );

this.lugar=lugar;
}
public ActividadPersonal(String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo, String lugar){

super(nombre, descripcion, fechaVencimiento,prioridad, tiempoEstimado, avance, tipo );

this.lugar=lugar;
}
//Getters
public String getLugar(){
    return this.lugar;
}
}
