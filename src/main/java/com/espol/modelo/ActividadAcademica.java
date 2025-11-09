package com.espol.modelo;

import java.time.LocalDateTime;
public class ActividadAcademica extends Actividad{
    protected String asignatura;
    protected String subtipo;
//Herencia donde se llaman 2 constructores diferentes, para poder colocar los valores iniciales.
public ActividadAcademica(int id, String nombre, String descripcion, LocalDateTime fechaVencimiento,  String prioridad, double tiempoEstimado, double avance, String tipo, String asignatura, String subtipo){
super(id, nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado, avance, tipo);
this.asignatura=asignatura;
this.subtipo=subtipo;
}
public ActividadAcademica(String nombre, String descripcion, LocalDateTime fechaVencimiento,  String prioridad, double tiempoEstimado, String tipo, String asignatura, String subtipo){
super(nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado, tipo);
this.asignatura=asignatura;
this.subtipo=subtipo;
}
//getters
public String getSubtipo(){
    return this.subtipo;
}
public String getAsignatura(){
    return this.asignatura;
}
}