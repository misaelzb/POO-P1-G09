//gestion de paquetes
package com.espol.vista;

//importacion de librerias
import java.util.Scanner;

import com.espol.controlador.ControladorControlDeHidratacion;

public class VistaControlDeHidratacion {
    Scanner in = new Scanner(System.in);

    //variables
    private ControladorControlDeHidratacion controlador_Hidratacion;

    //metodos

    //constructor
    public VistaControlDeHidratacion() {
        this.controlador_Hidratacion = new ControladorControlDeHidratacion();
    }
    
    //getter
    public ControladorControlDeHidratacion getControladorControlDeHidratacion(){
        return controlador_Hidratacion;
    }
    
    // Al ingresar la opcion 3 en Main:
    public void menu_ControlDeHidratacion(){
        clearConsole();

        System.out.println("1. Registrar Ingesta de Agua");
        System.out.println("2. Establecer meta diaria");
        System.out.println("3. Ver Progreso Diario y Meta");
        System.out.println("4. Volver al Menú Principal");
        System.out.print("Ingrese su opcion: ");
        switch (in.next()) {
            case "1":
            opcion_RegistrarIngestaDeAgua();
                break;
            case "2":
            opcion_EstablecerMetaDiaria();
                break;
            case "3":
            opcion_ProgresoDiarioYMeta();
                break;
            case "4":
                break;
            default:
            System.out.println("No Ingreso una opcion valida, Eliga una del 1 al 4");
                break;
        }

    }

    //Opcion 1: Registrar Ingesta de Agua
    public void opcion_RegistrarIngestaDeAgua(){
        clearConsole();

        System.out.print("--- REGISTRAR INGESTA DE AGUA ---");
        System.out.print("\nIngrese la cantidad de agua que ha tomado (en **mililitros**): ");
        int mililitros = in.nextInt();

        //Se ingresa el dato ingresado al controlador para que procese y se guarda el resultado en mensaje
        String mensaje = controlador_Hidratacion.RegistrarIngestaDeAgua(mililitros);
        System.out.println(mensaje);

        System.out.println("\n\nPresione [ENTER] para continuar...");
        in.nextLine();
        in.nextLine();

        //Se vuelve al menu
        menu_ControlDeHidratacion();
    }

    //Opcion 2: Establecer Meta Diaria
    public void opcion_EstablecerMetaDiaria(){
        clearConsole();
        
        //se requiere ingresar la nueva meta y la confirmacion
        System.out.println("--- ESTABLECER META DIARIA DE HIDRATACIÓN ---");
        System.out.println("Meta diaria actual: " + controlador_Hidratacion.getMetaDeHidratacion() + " ml");
        System.out.print("\n la nueva meta diaria de hidratación (en **mililitros**): ");
        int nuevaMeta = in.nextInt();
        System.out.print("\n\n¿Confirma que la nueva meta diaria es **" + nuevaMeta + " ml**?  (S/N): ");
        String confirmacion = in.next();

        //Casos de la confirmacion
        if(confirmacion.equals("S")){
            System.out.println("\nMeta diaria de hidratación actualizada a **" + nuevaMeta + "ml** con éxito.");
            //Se ingresa el dato al controlador para que procese y se guarda el resultado en un mensaje
            String mensaje = controlador_Hidratacion.establecerMetaDiaria(nuevaMeta);
            System.out.println(mensaje);

        }else if(confirmacion.equals("N")){
            System.out.println("\nLa Meta diaria no se ha actualizado.");

        }else {
            System.out.println("\nRespuesta no válida. Debe escribir S o N.");

        }

        System.out.println("\n\nPresione [ENTER] para volver al menú...");
        in.nextLine();
        in.nextLine();

        //Se vuelve al menu
        menu_ControlDeHidratacion();

    }

    //Opcion 3: Ver Progreso Diario y Meta:
    public void opcion_ProgresoDiarioYMeta(){
        clearConsole();

        System.out.println("Fecha: "+controlador_Hidratacion.getFecha());
        System.out.println("--- PROGRESO DE HIDRATACIÓN DIARIA ---");
        System.out.println("Meta Diria (ML): " + controlador_Hidratacion.getMetaDeHidratacion() + " ml");
        System.out.println("Ingesta Acumulada " + controlador_Hidratacion.getAguaAcumulada() + " ml\n");
        String mensaje = controlador_Hidratacion.ProgresoDiarioYMeta();
        System.out.println(mensaje);
        System.out.println("-------------------------------------");
        System.out.println("¡Recuerda mantenerte hidratado! ");
        System.out.println("\n\nPresione [ENTER] para volver al menú...");
        in.nextLine();
        in.nextLine();

        //Se vuelve al menu
        menu_ControlDeHidratacion();
    }



    //para limpiar consola
    public static void clearConsole() {
        System.out.print("\033\143");
    }
    
    


}
