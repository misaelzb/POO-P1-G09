package com.espol.modelo;
import java.time.LocalDateTime;
public class Actividad {
protected int id;
protected String nombre;
protected String descripcion;
protected LocalDateTime fechaVencimiento;
protected String prioridad;
protected double tiempoEstimado;
protected double avance;
protected String tipo;
protected static int idcrecimiento=5;
//Por comodidad en un tiempo desarrollé 4 constructores, ademas de todos los atributos protegidos para poder trabajar mejor en la subclase Vista
public Actividad(String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo){
    id=idcrecimiento++;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.fechaVencimiento=fechaVencimiento;
    this.prioridad=prioridad;
    this.tiempoEstimado=tiempoEstimado;
    this.avance=avance;
    this.tipo=tipo;
}
public Actividad(int id, String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo){
    this.id=id;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.fechaVencimiento=fechaVencimiento;
    this.prioridad=prioridad;
    this.tiempoEstimado=tiempoEstimado;
    this.avance=avance;
    this.tipo=tipo;
}
public Actividad(String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, String tipo){
    id=idcrecimiento++;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.fechaVencimiento=fechaVencimiento;
    this.prioridad=prioridad;
    this.tiempoEstimado=tiempoEstimado;
    avance=0.0;
    this.tipo=tipo;
}
public Actividad(){
    this.id=00;
    this.nombre="a";
    this.descripcion="a";
    this.fechaVencimiento=LocalDateTime.now();
    this.prioridad="a";
    this.avance=0.0;
    this.tipo="i";
}
//getters
public int getId(){
    return this.id;
}
public String getNombre(){
    return this.nombre;
}
public String getDescripcion(){
    return this.descripcion;
}
public LocalDateTime getFechavencimiento(){
    return this.fechaVencimiento;
}
public String getPrioridad(){
    return this.prioridad;
}
public double getTiempoEstimado(){
    return this.tiempoEstimado;
}
public double getAvance(){
    return this.avance;
    
}
public String getTipo(){
    return this.tipo;
}
//Setter
public void setAvance(double avance){
    this.avance=avance;
}
}

