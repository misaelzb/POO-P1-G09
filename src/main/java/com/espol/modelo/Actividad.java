package espol.poo.modelo;
import java.util.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Actividad {
protected int id;
protected String nombre;
protected String descripcion;
protected LocalDateTime fechaVencimiento;
protected String prioridad;
protected double tiempoEstimado;
protected double avance;
protected String tipo;
protected ArrayList historialTiempo;
protected static int idcrecimiento=0;

public Actividad(int id, String nombre, String descripcion, LocalDateTime fechaVencimiento, String prioridad, double tiempoEstimado, double avance, String tipo){
    this.id=idcrecimiento++;
    this.nombre=nombre;
    this.descripcion=descripcion;
    this.fechaVencimiento=fechaVencimiento;
    this.prioridad=prioridad;
    this.tiempoEstimado=tiempoEstimado;
    this.avance=avance;
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
public int getId(){
    return this.id;
}
public String getN(){
    return this.nombre;
}
public String getD(){
    return this.descripcion;
}
public LocalDateTime getL(){
    return this.fechaVencimiento;
}
public String getP(){
    return this.prioridad;
}
public double getT(){
    return this.tiempoEstimado;
}
public double getA(){
    return this.avance;
    
}
public String getE(){
    return this.tipo;
}

public void setAvance(double avance){
    this.avance=avance;
}
}

