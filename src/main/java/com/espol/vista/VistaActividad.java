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
//Creacion de una tabla
System.out.println("");
System.out.println("----LISTADO DE ACTIVIDADES PENDIENTES---------------");
System.out.println("");
System.out.println("");
//Creacion de un formato para print f
String formato = "| %-3s | %-10s | %-35s | %-11s | %-10s | %-6s |\n";
//encabezado
System.out.printf(formato, "ID", "TIPO", "NOMBRE", "VENCIMIENTO", "PRIORIDAD", "AVANCE");
//Se crea un formatter para los datos de tiempo
DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
System.out.println("|-----|------------|-------------------------------------|-------------|------------|--------|");
//Creacion de tabla por for.
for (Actividad act:controlador.getLista()){
    String  fecha=act.getFechavencimiento().toLocalDate().format(formatter);
    String avanceFormateado = act.getAvance() + "%";
//exclusion de actividades vencidas
if(act.getFechavencimiento().isAfter(LocalDateTime.now())){
    if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
    System.out.printf(formato, act.getId(), w.getSubtipo(), act.getNombre(), fecha, act.getPrioridad(), avanceFormateado);
    }
    if(act instanceof ActividadPersonal){
        
    System.out.printf(formato, act.getId(), act.getTipo(), act.getNombre(), fecha, act.getPrioridad(), avanceFormateado);
    }
}
}
//ejecuta otro metodo
mostrarDetalles(controlador);
}
public void crearActividad(ControladorActividad controlador){
    //Metodo padre para crear actividades
    Scanner w= new Scanner(System.in);
    System.out.println("Seleccione la categoría de la actividad:\r\n" + //
                "1. ACADÉMICA (Tarea, Examen, Proyecto)\r\n" + //
                "2. PERSONAL (Citas, Ejercicio, Hobbies)\r\n" + //
                "");
    int i=w.nextInt();
    if(i==1){
        //Llama al metodo creador de Actividad Académica.
        crearActividadAcademica(controlador);
    }
    if(i==2){
        //Llama al metodo creador de Actividad Personal.
        crearActividadPersonal(controlador);
    }

}
public void crearActividadPersonal(ControladorActividad controlador){
    //Presenta un pequeño encabezado
    System.out.println("====PASO 2: TIPO====");
    System.out.println("Has seleccionado:  PERSONAL");
    System.out.println("====PASO 3: DETALLES====");
    Scanner a=new Scanner(System.in);
    //Se ingresan los datos por teclado.
    System.out.println("Ingrese el nombre de la actividad: ");
    String n=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la descripción: ");
    String d=a.nextLine();
    a.nextLine();
    System.out.println("Ingrese la fecha (DD/MM/AAAA): ");
    String t=a.nextLine();
    //Se verifica el formato de la fecha.
      while(!Verificarformato(t)){
        System.out.println("Formato Incorrecto.... Ingrese la fecha (DD/MM/AAAA): ");
        t=a.nextLine();
    while(!esEntero(t.substring(0,2))&&esEntero(t.substring(3,5))&&esEntero(t.substring(6))){
        System.out.println("Formato Incorrecto.... Ingrese la fecha (DD/MM/AAAA): ");
        t=a.nextLine();
    }
}
    a.nextLine();
    //Se verifica el formato de hora.
    System.out.println("Ingrese la hora (hh:mm): ");
    String h=a.nextLine();
    while (!Verificarformatoh(h)){
        System.out.println("Formato Incorrecto.... Ingrese la hora (hh:mm): ");
        h=a.nextLine();
    }
    while(!esEntero(h.substring(0,2))&&esEntero(h.substring(3))){
        System.out.println("Formato Incorrecto.... Ingrese la hora (hh:mm): ");
        h=a.nextLine();
    }
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
    //se separa el string de fecha y hora en un array donde se convierten a int para su posterior conversion a LocalDateTime
    String[] w=t.split("/");
    int dia=Integer.parseInt(w[0]);
    int mes=Integer.parseInt(w[1]);
    int año=Integer.parseInt(w[2]);
    String [] u=h.split(":");
    int hora=Integer.parseInt(u[0]);
    int min=Integer.parseInt(u[1]);
    LocalDateTime g=LocalDateTime.of(año,mes,dia,hora,min,0);
    //se invoca al metodo creador.
    controlador.crearActividadPersonal(n,d,g,p,e,l);
    //Mensaje de creacion con éxito.
    System.out.println("==========================================");
    System.out.println("ACTIVIDAD PERSONAL '"+ n +"' creada con éxito");
    System.out.println("==========================================");
    System.out.println("Presione [ENTER] para volver al menú principal");
    a.nextLine();
    menu_GestiónActividades(controlador);
}
public void crearActividadAcademica(ControladorActividad controlador){
    Scanner a=new Scanner(System.in);
    //Encabezado
    System.out.println("====PASO 2: TIPO====");
    System.out.println("Has seleccionado: ACADÉMICA");
    System.out.println("Seleccione el tipo específico: ");
    System.out.println("1. TAREA");
    System.out.println("2. EXAMEN");
    System.out.println("3. PROYECTO");
    System.out.println("Ingrese una opción(1-3): ");
    int s=a.nextInt();
    a.nextLine();
    String o="NO DEFINIDO";
    //seleccion y validacion    de subtipo
    while(s>3){
        System.out.println("Opción no válida");
          System.out.println("Seleccione el tipo específico: ");
        System.out.println("1. TAREA");
        System.out.println("2. EXAMEN");
        System.out.println("3. PROYECTO");
        System.out.println("Ingrese una opción(1-3): ");
        s=a.nextInt();
    }
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
     //Ingreso de datos por teclado
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
    //validacion de formato de fecha
    while(!Verificarformato(t)){
        System.out.println("Formato Incorrecto.... Ingrese la fecha (DD/MM/AAAA): ");
        t=a.nextLine();   
}
while(!esEntero(t.substring(0,2))&&esEntero(t.substring(3,5))&&esEntero(t.substring(6))){
        System.out.println("Formato Incorrecto.... Ingrese la fecha (DD/MM/AAAA): ");
        t=a.nextLine();
    }
    a.nextLine();
    System.out.println("Ingrese la hora (hh:mm): ");
    String h=a.nextLine();
    //validacion de formato de hora
     while (!Verificarformatoh(h)){
        System.out.println("Formato Incorrecto.... Ingrese la hora (hh:mm): ");
        h=a.nextLine();
    }
    while(!esEntero(h.substring(0,2))&&esEntero(h.substring(3))){
        System.out.println("Formato Incorrecto.... Ingrese la hora (hh:mm): ");
        h=a.nextLine();
    }
    a.nextLine();
    System.out.println("Ingrese Prioridad (ALTA, MEDIA, BAJA): ");
    String p=a.nextLine();
    a.nextLine();
     System.out.println("Ingrese el tiempo aproximado (En minutos)");
    double e=a.nextDouble();
    a.nextLine();
//se separa el string de fecha y hora en un array donde se convierten a int para su posterior conversion a LocalDateTime
    String[] w=t.split("/");
    int dia=Integer.parseInt(w[0]);
    int mes=Integer.parseInt(w[1]);
    int año=Integer.parseInt(w[2]);
    String [] u=h.split(":");
    int hora=Integer.parseInt(u[0]);
    int min=Integer.parseInt(u[1]);
    LocalDateTime ñ=LocalDateTime.of(año,mes,dia,hora,min);
//se invoca el metodo creador
    controlador.crearActividadAcademica(n,d,ñ,p,e,y,o);
//muestra mensaje de éxito.
    System.out.println("==========================================");
    System.out.println("ACTIVIDAD ACADEMICA '"+ n+"' creada con éxito");
    System.out.println("==========================================");
    System.out.println("Presione [ENTER] para volver al menú principal");
    a.nextLine();
//regreso al menu de actividades
    menu_GestiónActividades(controlador);
}
public void mostrarDetalles(ControladorActividad controlador){
Scanner o=new Scanner(System.in);
System.out.println("Ingrese el ID para ver --Detalles--, o presione 0 para volver al menú");
int id=o.nextInt();
//valida el id
id=ValidacionDeID(controlador,id);
if (id>0){
    for (Actividad act:controlador.getLista()){
        int k=act.getId();
        DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //Se busca la actividad con el id correspondiente
        if(id==k){
            //Para mas detalle se verifica si la actividad pertenece a una subclase o no.
            if(act instanceof ActividadAcademica){
            //se hace el cast correspondiente
            ActividadAcademica w= (ActividadAcademica) act;
             System.out.println("===============================");
            System.out.println("  DETALLES DEL "+ w.getSubtipo()+"(ID "+w.getId()+" )" );
            System.out.println("===============================");
            //Se verifica el vencimiento
             if(w.getFechavencimiento().isBefore(LocalDateTime.now())){
                System.out.println("---ACTIVIDAD VENCIDA!!!!!!---");
            }
            System.out.println("Nombre: "+w.getNombre());
            System.out.println("Tipo: "+w.getSubtipo());
            System.out.println("Asignatura: "+w.getAsignatura());
            System.out.println("Prioridad: "+ w.getPrioridad() );
            //se verifica el avance
            if(w.getAvance()<100){
            System.out.println("Estado: "+"En curso");
            }
            else{
               System.out.println("Estado: "+"Completado"); 
            }

            String  fecha=act.getFechavencimiento().toLocalDate().format(formatter);
            System.out.println("Fecha límite: "+fecha);
            System.out.println("Tiempo Estimado: "+ w.getTiempoEstimado()+" minutos");
            System.out.println("Avance Actual: " + w.getAvance()+"%" );
            System.out.println("Presione [ENTER] para volver  la lista");
            o.nextLine();
            o.nextLine();
            //se invoca al listado de actividades
            listadodeactividades(controlador);
        }
        else{
            //se hace el cast correspondiente
            ActividadPersonal w= (ActividadPersonal) act;
             System.out.println("===============================");
            System.out.println("  DETALLES DE LA ACTIVIDAD PERSONAL (ID "+w.getId()+" )" );
            System.out.println("===============================");
             if(w.getFechavencimiento().isBefore(LocalDateTime.now())){
                System.out.println("---ACTIVIDAD VENCIDA!!!!!!---");
            }
            System.out.println("Nombre: "+w.getNombre());
            System.out.println("Tipo: "+w.getTipo());
            System.out.println("Lugar: "+w.getLugar());
            System.out.println("Prioridad: "+ w.getPrioridad() );
            if(w.getAvance()<100){
            System.out.println("Estado: "+"En curso");
            }
            else{
               System.out.println("Estado: "+"Completado"); 
            }
            String  fecha=act.getFechavencimiento().toLocalDate().format(formatter);
            System.out.println("Fecha límite: "+fecha);
            System.out.println("Tiempo Estimado: "+ w.getTiempoEstimado()+" minutos");
            System.out.println("Avance Actual: " + w.getAvance()+"%" );
            System.out.println("Presione [ENTER] para volver  la lista");
            o.nextLine();
             o.nextLine();
             //se invoca la lista
            listadodeactividades(controlador);
        }
    }
    }
} 
else{
    //se invoca al menu principal en caso de ser 0
    menu_GestiónActividades(controlador);
}
}

public void registroAvance(ControladorActividad controlador){
 //Encabezado
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
    String  fecha=act.getFechavencimiento().toLocalDate().format(formatter);
    String avanceFormateado = act.getAvance() + "%";
if(act.getFechavencimiento().isAfter(LocalDateTime.now())){
    if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
    System.out.printf(formato, act.getId(), w.getSubtipo(), act.getNombre(), fecha, act.getPrioridad(), avanceFormateado);
    }
    if(act instanceof ActividadPersonal){
        
    System.out.printf(formato, act.getId(), act.getTipo(), act.getNombre(), fecha, act.getPrioridad(), avanceFormateado);
    }
}
}
System.out.println("Ingrese el ID de la actividad a actualizar (o 0 para salir)");
int e= o.nextInt();
e=ValidacionDeID(controlador, e);
if (e>0){
for (Actividad act:controlador.getLista()){
        int k=act.getId();
    if(k==e){   
       //Para mas detalle se verifica si la actividad pertenece a una subclase o no.
       if(act instanceof ActividadAcademica){
        ActividadAcademica w= (ActividadAcademica) act;
        System.out.println("Ha selecionado: "+ w.getSubtipo()+" '"+w.getNombre()+"' ");
        System.out.println("Avance actual: "+w.getAvance()+"%");
        //se ingresa el avance
        System.out.println("Ingrese el **nuevo avance** (1-100): ");
        double t=o.nextDouble();
        o.nextLine();
        //se confirma el avance
        System.out.println("¿Confirma que el nuevo avance para "+w.getSubtipo().toLowerCase()+" ID "+w.getId()+" es "+ t+ "%? (S/N): ");
        String j=o.nextLine();
        if(j.equals("S")){
            //se invoca el metodo de registro de avance
           controlador.registroAvance(e,act, t);
        }
        System.out.println("Presione [ENTER] para volver al menú principal");
        o.nextLine();
        //menu
        menu_GestiónActividades(controlador);
         }
 //Para mas detalle se verifica si la actividad pertenece a una subclase o no.
        if(act instanceof ActividadPersonal){
            //se hace el cast
            ActividadPersonal w= (ActividadPersonal) act;
            System.out.println("Ha selecionado: Actividad PERSONAL '"+w.getNombre()+"' ");
            System.out.println("Avance actual: "+w.getAvance()+"%");
            System.out.println("Ingrese el **nuevo avance** (1-100): ");
            //se ingresa el avance
            double t=o.nextDouble();
            o.nextLine();
            //se confirma el avance
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
    String  fecha=act.getFechavencimiento().toLocalDate().format(formatter);
    String avanceFormateado = act.getAvance() + "%";
    if(act.getFechavencimiento().isAfter(LocalDateTime.now())){
    if(act instanceof ActividadAcademica){
//Para mas detalle se verifica si la actividad pertenece a una subclase o no.
        ActividadAcademica w= (ActividadAcademica) act;
    System.out.printf(formato, act.getId(), w.getSubtipo(), act.getNombre(), fecha, act.getPrioridad(), avanceFormateado);
    }
    if(act instanceof ActividadPersonal){
 //Para mas detalle se verifica si la actividad pertenece a una subclase o no.
    System.out.printf(formato, act.getId(), act.getTipo(), act.getNombre(), fecha, act.getPrioridad(), avanceFormateado);
    }
}
}
    System.out.println("Ingrese el ID de la actividad a ELIMINAR(o para cancelar): ");
    int e= o.nextInt();
    //se valida el id
    e=ValidacionDeID(controlador, e);
    if (e>0){
        String conf;
        Actividad actividadaeliminar= null;
    for (Actividad act:controlador.getLista()){
        int k=act.getId();
        if(k==e){  
        System.out.println("Usted seleccionó la actividad ID "+act.getId()+": '"+act.getNombre()+" '"+"(TIPO: "+act.getTipo()+" )");
        actividadaeliminar=act;
        break;
    }
    }
    //se confirma la eliminacion
    conf=Confirmacion();
    //se invoca el eliminador
    controlador.eliminarActividad(conf, actividadaeliminar);
    //regresa al menu
    menu_GestiónActividades(controlador);
    }
    else{
        //regresa al menu
        menu_GestiónActividades(controlador);
    }
}
//Metodo de confirmacion
public String Confirmacion(){
    Scanner o= new Scanner(System.in);
    System.out.println("¿Está seguro que desea ELIMINAR PERMANENTEMENTE esta actividad? (S/N):  ");
    String conf=o.nextLine().toUpperCase();
    return conf;
}
//metodo clear console
 public static void clearConsole() {
        System.out.print("\033\143");
    }
//Menu
    public void menu_GestiónActividades(ControladorActividad a){
        clearConsole();
        Scanner in=new Scanner(System.in);
        System.out.println("------------Opciones a realizar------------");
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
//Metodo de valicacion
public int ValidacionDeID(ControladorActividad a, int o){
    Scanner u=new Scanner(System.in); 
    int P=a.getLista().size();
    while(o>P){
        System.out.print("OPCION FUERA DE RANGO.... Ingrese de nuevo: ");
         o=u.nextInt();
        
    }
    return o;
}
//Metodo de verificacion
public boolean Verificarformato(String j){
   String Signo1=j.substring(2,3);
   String Signo2=j.substring(5,6);
    return Signo1.equals("/") && Signo2.equals("/");
}
//Metodo de verificacion
public boolean Verificarformatoh(String a){
    String Signo1=a.substring(2,3);
    return Signo1.equals(":");
}
//Metodo de validacion de enteros
public boolean esEntero(String s) {
    try {
        Integer.parseInt(s);
        return true; 
    } catch (NumberFormatException e) {
        return false; 
    }
}
}

