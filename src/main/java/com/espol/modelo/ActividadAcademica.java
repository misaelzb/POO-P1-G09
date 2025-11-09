package espol.poo.modelo;
import java.util.*;
import java.time.LocalDateTime;
public class ActividadAcademica extends Actividad{
    protected String asignatura;
    protected String subtipo;
public ActividadAcademica(int id, String nombre, String descripcion, LocalDateTime fechaVencimiento,  String prioridad, double tiempoEstimado, double avance, String tipo, String asignatura, String subtipo){
super(id, nombre, descripcion, fechaVencimiento, prioridad, tiempoEstimado, avance, tipo);
this.asignatura=asignatura;
this.subtipo=subtipo;
}
public String getS(){
    return this.subtipo;
}
public String getK(){
    return this.asignatura;
}
}