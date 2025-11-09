package com.espol.controlador;
import java.time.LocalDateTime;
import java.util.*;
import com.espol.modelo.*;

public class ControladorActividad {
private ArrayList<Actividad> listaactividades;
//constructor con atributo de lista
    public ControladorActividad(){
        listaactividades=new ArrayList<>();
}
//metodo setter
public void setLista(ArrayList<Actividad> listaActividades){
    this.listaactividades=listaActividades;

}
//Metodos creadores
public void crearActividadPersonal( String n, String d, LocalDateTime t, String p, double e, String l){
    ActividadPersonal actividad= new ActividadPersonal(n,d,t ,p,e,0.0,"PERSONAL",l);
    listaactividades.add(actividad);
}
public void crearActividadPersonal(int c, String n, String d, LocalDateTime t, String p, double e, double a, String l){
    ActividadPersonal actividad= new ActividadPersonal(c,n,d,t ,p,e,a,"PERSONAL",l);
    listaactividades.add(actividad);


}
public void crearActividadAcademica(String n, String d, LocalDateTime t, String p, double e, String y, String o){
    ActividadAcademica actividad= new ActividadAcademica(n,d,t,p,e,"ACADEMICO",y,o);
    listaactividades.add(actividad);

}
public void crearActividadAcademica(int c, String n, String d, LocalDateTime t, String p, double e, double a, String y, String o){
    ActividadAcademica actividad= new ActividadAcademica(c,n,d,t,p,e,a,"ACADEMICO",y,o);
    listaactividades.add(actividad);

}
public void crearActividadAcademica(int c, String n, String d, LocalDateTime t, String p, double e, double a, String y, String o, ControladorSesionEnfoque controladorSesionEnfoque){
    ActividadAcademica actividad= new ActividadAcademica(c,n,d,t,p,e,a,"ACADEMICO",y,o, controladorSesionEnfoque);
    listaactividades.add(actividad);

}
//Metodo de eliminacion
public void eliminarActividad(String conf, Actividad act){  
    if(conf.equals("S")){
        listaactividades.remove(act);
    }
    }
//Metodo de registro de avance
public void registroAvance(int e, Actividad w, double t){
    w.setAvance(t);
}


//GETTER
public ArrayList<Actividad> getLista(){
    return listaactividades;
}

}
