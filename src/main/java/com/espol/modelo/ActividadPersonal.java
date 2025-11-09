package com.espol.modelo;
import java.time.LocalDateTime;
import java.util.*;
public class ActividadPersonal extends Actividad{
protected String lugar;
public ActividadPersonal( int id,String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo, String lugar){

super(id, nombre, descripcion, fechaVencimiento,prioridad, tiempoEstimado, avance, tipo );

this.lugar=lugar;
}
public ActividadPersonal(String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo, String lugar){

super(nombre, descripcion, fechaVencimiento,prioridad, tiempoEstimado, avance, tipo );

this.lugar=lugar;
}
public String getLu(){
    return this.lugar;
}
}
