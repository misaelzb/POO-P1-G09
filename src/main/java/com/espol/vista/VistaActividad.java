package com.espol.vista;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.ResourceBundle.Control;

import com.espol.controlador.ControladorActividad;
import com.espol.modelo.Actividad;
import com.espol.modelo.ActividadAcademica;
import com.espol.modelo.ActividadPersonal;


public class VistaActividad extends Actividad{
    
public void listadodeactividades(ControladorActividad controlador){
System.out.println("");
System.out.println("----LISTADO DE ACTIVIDADES PENDIENTES---------------");
System.out.println("");
System.out.println("");
String formato = "| %-3s | %-10s | %-35s | %-11s | %-10s | %-6s |\n";
System.out.printf(formato, "ID", "TIPO", "NOMBRE", "VENCIMIENTO", "PRIORIDAD", "AVANCE");
DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
System.out.println("|-----|------------|-------------------------------------|-------------|------------|--------|");
for (Actividad act:controlador.getLista()){
    String  fecha=act.getL().toLocalDate().format(formatter);
    String avanceFormateado = act.getA() + "%";
if(act.getL().isAfter(LocalDateTime.now())){
    if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
    System.out.printf(formato, act.getId(), w.getS(), act.getN(), fecha, act.getP(), avanceFormateado);
    }
    if(act instanceof ActividadPersonal){
        
    System.out.printf(formato, act.getId(), act.getE(), act.getN(), fecha, act.getP(), avanceFormateado);
    }
}
}
mostrarDetalles(controlador);
}
public void crearActividad(ControladorActividad controlador){
    Scanner w= new Scanner(System.in);
    System.out.println("Seleccione la categoría de la actividad:\r\n" + //
                "1. ACADÉMICA (Tarea, Examen, Proyecto)\r\n" + //
                "2. PERSONAL (Citas, Ejercicio, Hobbies)\r\n" + //
                "");
    int i=w.nextInt();
    if(i==1){
        crearActividadAcademica(controlador);
    }
    if(i==2){
        crearActividadPersonal(controlador);
    }

}
public void crearActividadPersonal(ControladorActividad controlador){
    System.out.println("====PASO 2: TIPO====");
    System.out.println("Has seleccionado:  PERSONAL");
    System.out.println("====PASO 3: DETALLES====");
    Scanner a=new Scanner(System.in);
    System.out.println("Ingrese el nombre de la actividad: ");
    String n=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la descripción: ");
    String d=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
    String t=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la hora (hh:mm): ");
    String h=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese Prioridad (ALTA, MEDIA, BAJA): ");
    String p=a.nextLine();
    a.nextLine();
     System.out.println("Ingrese el tiempo aproximado (En minutos)");
    double e=a.nextDouble();
    a.nextLine();
     System.out.println("Ingrese el lugar: ");
    String l=a.nextLine();
    a.nextLine();
    String[] w=t.split("/");
    int dia=Integer.parseInt(w[0]);
    int mes=Integer.parseInt(w[1]);
    int año=Integer.parseInt(w[2]);
    String [] u=h.split(":");
    int hora=Integer.parseInt(u[0]);
    int min=Integer.parseInt(u[1]);
    LocalDateTime g=LocalDateTime.of(año,mes,dia,hora,min,0);
    controlador.crearActividadPersonal(n,d,g,p,e,l);
    System.out.println("==========================================");
    System.out.println("ACTIVIDAD PERSONAL '"+ n +"' creada con éxito");
    System.out.println("==========================================");
    System.out.println("Presione [ENTER] para volver al menú principal");
    a.nextLine();
    menu_GestiónActividades(controlador);
}
public void crearActividadAcademica(ControladorActividad controlador){
    Scanner a=new Scanner(System.in);
    System.out.println("====PASO 2: TIPO====");
    System.out.println("Has seleccionado: ACADÉMICA");
    System.out.println("Seleccione el tipo específico: ");
    System.out.println("1. TAREA");
    System.out.println("2. EXAMEN");
    System.out.println("3. PROYECTO");
    System.out.println("Ingrese una opción(1-3): ");
    int s=a.nextInt();
    a.nextLine();
    String o="a";
    if(s==1){
        o="TAREA";
    }
    if(s==2){
        o="EXAMEN";
    }
    if(s==3){
        o="PROYECTO";
    }
     System.out.println("====PASO 3: DETALLES====");
    System.out.println("Ingrese el nombre del "+o +" :" );
    String n=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la descripción: ");
    String d=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la asignatura: ");
    String y=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
    String t=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la hora (hh:mm): ");
    String h=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese Prioridad (ALTA, MEDIA, BAJA): ");
    String p=a.nextLine();
    a.nextLine();
     System.out.println("Ingrese el tiempo aproximado (En minutos)");
    double e=a.nextDouble();
    a.nextLine();

    String[] w=t.split("/");
    int dia=Integer.parseInt(w[0]);
    int mes=Integer.parseInt(w[1]);
    int año=Integer.parseInt(w[2]);
    String [] u=h.split(":");
    int hora=Integer.parseInt(u[0]);
    int min=Integer.parseInt(u[1]);
    LocalDateTime ñ=LocalDateTime.of(año,mes,dia,hora,min);
    controlador.crearActividadAcademica(n,d,ñ,p,e,y,o);
    System.out.println("==========================================");
    System.out.println("ACTIVIDAD ACADEMICA '"+ n+"' creada con éxito");
    System.out.println("==========================================");
    System.out.println("Presione [ENTER] para volver al menú principal");
    a.nextLine();
    menu_GestiónActividades(controlador);
}
public void mostrarDetalles(ControladorActividad controlador){
Scanner o=new Scanner(System.in);
System.out.println("Ingrese el ID para ver --Detalles--, o presione 0 para volver al menú");
int id=o.nextInt();
if (id>0){
    for (Actividad act:controlador.getLista()){
        int k=act.getId();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        if(id==k){
            if(act instanceof ActividadAcademica){
            ActividadAcademica w= (ActividadAcademica) act;
             System.out.println("===============================");
            System.out.println("  DETALLES DEL "+ w.getS()+"(ID "+w.getId()+" )" );
            System.out.println("===============================");
            System.out.println("Nombre: "+w.getN());
            System.out.println("Tipo: "+w.getS());
            System.out.println("Asignatura: "+w.getK());
            System.out.println("Prioridad: "+ w.getP() );
            if(w.getA()<100){
            System.out.println("Estado: "+"En curso");
            }
            else{
               System.out.println("Estado: "+"Completado"); 
            }
            String  fecha=act.getL().toLocalDate().format(formatter);
            System.out.println("Fecha límite: "+fecha);
            System.out.println("Tiempo Estimado: "+ w.getT()+" minutos");
            System.out.println("Avance Actual: " + w.getA()+"%" );
            System.out.println("Presione [ENTER] para volver  la lista");
            o.nextLine();
            o.nextLine();
            listadodeactividades(controlador);
        }
        else{
            ActividadPersonal w= (ActividadPersonal) act;
             System.out.println("===============================");
            System.out.println("  DETALLES DE LA ACTIVIDAD PERSONAL (ID "+w.getId()+" )" );
            System.out.println("===============================");
            System.out.println("Nombre: "+w.getN());
            System.out.println("Tipo: "+w.getE());
            System.out.println("Lugar: "+w.getLu());
            System.out.println("Prioridad: "+ w.getP() );
            if(w.getA()<100){
            System.out.println("Estado: "+"En curso");
            }
            else{
               System.out.println("Estado: "+"Completado"); 
            }
            String  fecha=act.getL().toLocalDate().format(formatter);
            System.out.println("Fecha límite: "+fecha);
            System.out.println("Tiempo Estimado: "+ w.getT()+" minutos");
            System.out.println("Avance Actual: " + w.getA()+"%" );
            System.out.println("Presione [ENTER] para volver  la lista");
            o.nextLine();
             o.nextLine();
            listadodeactividades(controlador);
        }
    }
    }
} 
else{
    menu_GestiónActividades(controlador);
}
}

public void registroAvance(ControladorActividad controlador){
System.out.println("REGISTRO DE AVANCE");
System.out.println("-----------------------------------");
Scanner o=new Scanner(System.in);
System.out.println("");
System.out.println("");
System.out.println("");
String formato = "| %-3s | %-10s | %-35s | %-11s | %-10s | %-6s |\n";
System.out.printf(formato, "ID", "TIPO", "NOMBRE", "VENCIMIENTO", "PRIORIDAD", "AVANCE");
DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
System.out.println("|-----|------------|-------------------------------------|-------------|------------|--------|");
for (Actividad act:controlador.getLista()){
    String  fecha=act.getL().toLocalDate().format(formatter);
    String avanceFormateado = act.getA() + "%";
if(act.getL().isAfter(LocalDateTime.now())){
    if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
    System.out.printf(formato, act.getId(), w.getS(), act.getN(), fecha, act.getP(), avanceFormateado);
    }
    if(act instanceof ActividadPersonal){
        
    System.out.printf(formato, act.getId(), act.getE(), act.getN(), fecha, act.getP(), avanceFormateado);
    }
}
}
System.out.println("Ingrese el ID de la actividad a actualizar (o 0 para salir)");
int e= o.nextInt();

if (e>0){
for (Actividad act:controlador.getLista()){
        int k=act.getId();
    if(k==e){   
       if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
        System.out.println("Ha selecionado: "+ w.getS()+" '"+w.getN()+"' ");
        System.out.println("Avance actual: "+w.getA()+"%");
        System.out.println("Ingrese el **nuevo avance** (1-100): ");
        double t=o.nextDouble();
        o.nextLine();
        System.out.println("¿Confirma que el nuevo avance para "+w.getS().toLowerCase()+" ID "+w.getId()+" es "+ t+ "%? (S/N): ");
        String j=o.nextLine();
        if(j.equals("S")){
           controlador.registroAvance(e,act, t);
        }
        System.out.println("Presione [ENTER] para volver al menú principal");
        o.nextLine();
        menu_GestiónActividades(controlador);
         }
        if(act instanceof ActividadPersonal){
            ActividadPersonal w= (ActividadPersonal) act;
            System.out.println("Ha selecionado: Actividad PERSONAL '"+w.getN()+"' ");
            System.out.println("Avance actual: "+w.getA()+"%");
            System.out.println("Ingrese el **nuevo avance** (1-100): ");
            double t=o.nextDouble();
            o.nextLine();
             System.out.println("¿Confirma que el nuevo avance para la actividad PERSONAL  ID "+w.getId()+" es "+ t+ "%? (S/N): ");
        String j=o.nextLine().toUpperCase();
            if(j.equals("S")){
            controlador.registroAvance(e,act,t);
        }
        System.out.println("Presione [ENTER] para volver al menú principal");
        o.nextLine();
        menu_GestiónActividades(controlador);
        }
        }
}
}
}

public void eliminarActividad(ControladorActividad controlador){  
    System.out.println("ELIMINAR ACTIVIDAD");
    System.out.println("-----------------------------------");
    Scanner o=new Scanner(System.in);
    System.out.println("");
    System.out.println("");
    System.out.println("");
    String formato = "| %-3s | %-10s | %-35s | %-11s | %-10s | %-6s |\n";
    System.out.printf(formato, "ID", "TIPO", "NOMBRE", "VENCIMIENTO", "PRIORIDAD", "AVANCE");
    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
    System.out.println("|-----|------------|-------------------------------------|-------------|------------|--------|");
    for (Actividad act:controlador.getLista()){
    String  fecha=act.getL().toLocalDate().format(formatter);
    String avanceFormateado = act.getA() + "%";
    if(act.getL().isAfter(LocalDateTime.now())){
    if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
    System.out.printf(formato, act.getId(), w.getS(), act.getN(), fecha, act.getP(), avanceFormateado);
    }
    if(act instanceof ActividadPersonal){
        
    System.out.printf(formato, act.getId(), act.getE(), act.getN(), fecha, act.getP(), avanceFormateado);
    }
}
}
    System.out.println("Ingrese el ID de la actividad a ELIMINAR(o para cancelar): ");
    int e= o.nextInt();
    if (e>0){
        String conf;
        Actividad actividadaeliminar= null;
    for (Actividad act:controlador.getLista()){
        int k=act.getId();
        if(k==e){  
        System.out.println("Usted seleccionó la actividad ID "+act.getId()+": '"+act.getN()+" '"+"(TIPO: "+act.getE()+" )");
        actividadaeliminar=act;
        break;
    }
    }
    conf=Confirmacion();
    controlador.eliminarActividad(conf, actividadaeliminar);
    menu_GestiónActividades(controlador);
    }
    else{
        menu_GestiónActividades(controlador);
    }
}
public String Confirmacion(){
    Scanner o= new Scanner(System.in);
    System.out.println("¿Está seguro que desea ELIMINAR PERMANENTEMENTE esta actividad? (S/N):  ");
    String conf=o.nextLine().toUpperCase();
    return conf;
}
public int listadeopciones(){
    Scanner w=new Scanner(System.in);
    System.out.println("Opción 1 - Gestión de actividades\r\n" + //
                "");
    System.out.println("------------Opciones a realizar------------");
    System.out.println("1. Visualizar actividades");
    System.out.println("2. Crear actividad ");
    System.out.println("3. Registrar avance de actividad");
    System.out.println("4. Eliminar actividad");
    System.out.println("5. Volver al menú");
    int i= w.nextInt();
    return i;

}
 public static void clearConsole() {
        System.out.print("\033\143");
    }
    public void menu_GestiónActividades(ControladorActividad a){
        clearConsole();
        Scanner in=new Scanner(System.in);
        System.out.println("1. Visualizar actividades");
        System.out.println("2. Crear actividad");
        System.out.println("3. Registrar avance de actividad");
        System.out.println("4. Eliminar actividad");
        System.out.println("5. Volver al menú");
        System.out.print("Ingrese su opcion: ");
        switch (in.next()) {
            case "1":
            listadodeactividades(a);
                break;
            case "2":
            crearActividad(a);
                break;
            case "3":
            registroAvance(a);
                break;
            case "4":
            eliminarActividad(a);
            case "5":
                break;
            default:
            System.out.println("No Ingreso una opcion valida, Eliga una del 1 al 5");
                break;
        }

    }
}
