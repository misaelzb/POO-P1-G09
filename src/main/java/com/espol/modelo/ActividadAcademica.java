package com.espol.modelo;
import java.time.LocalDateTime;
import com.espol.controlador.ControladorSesionEnfoque;
public class ActividadAcademica extends Actividad{
    protected String asignatura;
    protected String subtipo;
    protected ControladorSesionEnfoque historialTiempo;
//Herencia donde se llaman 2 constructores diferentes, para poder colocar los valores iniciales.
public ActividadAcademica(int id, String nombre, String descripcion, LocalDateTime fechaVencimiento,  String prioridad, double tiempoEstimado, double avance, String tipo, String asignatura, String subtipo){
super(id, nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado, avance, tipo);
this.asignatura=asignatura;
this.subtipo=subtipo;
historialTiempo=new ControladorSesionEnfoque();
}
public ActividadAcademica(int id, String nombre, String descripcion, LocalDateTime fechaVencimiento,  String prioridad, double tiempoEstimado, double avance, String tipo, String asignatura, String subtipo, ControladorSesionEnfoque historialTiempo){
super(id, nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado, avance, tipo);
this.asignatura=asignatura;
this.subtipo=subtipo;
this.historialTiempo=historialTiempo;
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
public ControladorSesionEnfoque getControladorSesionEnfoque(){
    return this.historialTiempo;
}
}