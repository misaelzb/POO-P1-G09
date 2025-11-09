//gestion de paquetes
package com.espol.controlador;
import com.espol.modelo.ControlDeHidratacion;

//importacion de librerias
import java.time.LocalDate;
import java.time.LocalTime;

public class ControladorControlDeHidratacion {
    //variables
    public ControlDeHidratacion controlHidratacion;
    LocalDate hoy = LocalDate.now();
    //metodos
    
    //constructor
    public ControladorControlDeHidratacion() {
        this.controlHidratacion = new ControlDeHidratacion();
        
    }
    
    //Por si se necesita un registrode ingesta con una meta especifica y fecha personalizada
    public void CrearRegistros(int ingesta,int metaDeHidratacion, int hora, int minuto) {
        controlHidratacion.setMetaDeHidratacion(metaDeHidratacion);
        controlHidratacion.setCantidadAguaIngerida(ingesta, LocalTime.of(hora,minuto));
        controlHidratacion.sumarAguaAcumulada(ingesta);
    }

    //Por si se necesita un registro de ingesta con fecha personalizada
    public void CrearRegistros(int ingesta, int hora, int minuto) {
        controlHidratacion.setCantidadAguaIngerida(ingesta, LocalTime.of(hora,minuto));
        controlHidratacion.sumarAguaAcumulada(ingesta);
    }

    //metodo encargado de registrar la Ingesta de Agua (Opcion 1 del menu)
    public String RegistrarIngestaDeAgua(int ingesta){
        //ingresa cantidad ingerida
        controlHidratacion.setCantidadAguaIngerida(ingesta);


        //se obtiene el acumulado de antes
        int AguaAcumuladaAntes = controlHidratacion.getAguaAcumulada();

        //se actualiza el acumulado con la cantidad de agua ingerida
        controlHidratacion.sumarAguaAcumulada(ingesta);

        // se hace el calculo del porcentaje y se genera una barra para apreciar de manera grafica
        String barra = generarBarra(getAguaAcumulada(), getMetaDeHidratacion());

        //Se retorna a VistaControlDeHidratacion los resultados
        return "\nRegistro de " + ingesta + " ml añadido. \n\n"
            + "--- PROGRESO RAPIDO ---\n"
            + "Meta Diaria: " + getMetaDeHidratacion() + "ml\n"
            + "Acumulado hoy "+ getAguaAcumulada() + "ml (Antes eran " + AguaAcumuladaAntes + "ml)\n"
            + "Progreso: " + barra + " (" + getAguaAcumulada() + "/" + getMetaDeHidratacion() + ")";
    }

    //metodo encargado de establecer la meta diaria de hidratacion (Opcion 2 del menu)
    public String establecerMetaDiaria(int nuevaMeta){
        controlHidratacion.setMetaDeHidratacion(nuevaMeta);

        // se hace el calculo del porcentaje y se genera una barra para apreciar de manera grafica
        String barra = generarBarra(getAguaAcumulada(), getMetaDeHidratacion());

        return "\n--- PROGRESO ACTUALIZADO ---\n"
            +"Acumulado Hoy: " + getAguaAcumulada() + " ml\n"
            +"Nueva Meta: " + getMetaDeHidratacion() + " ml\n"
            + "Progreso: " + barra + " (" + getAguaAcumulada() + "/" + getMetaDeHidratacion() + ")";
    }

    //metodo encargado de mostrar el progreso diario y meta (Opcion 3 del menu)
    public String ProgresoDiarioYMeta(){

        //Se hace un string builder para contener todo lo que se va a imprimir
        StringBuilder mensaje = new StringBuilder();

        //calcula el faltante
        int faltante = getMetaDeHidratacion() - getAguaAcumulada();
        if (faltante < 0) faltante = 0;
        String barra = generarBarra(getAguaAcumulada(), getMetaDeHidratacion());

        //se ingresa el faltante y la barra al string builder
        mensaje.append("Falta " + faltante + " ml\n");
        mensaje.append(barra + "\n\n");

        //Se ingersa la lista al string builder si no esta vacia.
        if (controlHidratacion.getHorasRegistradas().isEmpty()) {
        mensaje.append("No hay registros de hoy todavía.\n");
        } else {
        mensaje.append("Historial de Registros de Hoy:\n");
        for (String hora : controlHidratacion.getHorasRegistradas()) {
            mensaje.append("- ").append(hora).append("\n");
        }
        }
        return mensaje.toString();

    }

    //generador de barra 
    private String generarBarra(int getAguaAcumulada, int getMetaDeHidratacion){
        int llenos;
        int porcentajeMeta;
        
        if(getAguaAcumulada >= getMetaDeHidratacion){
            llenos = 20;
            porcentajeMeta = 100;
        } else{
            porcentajeMeta = (getAguaAcumulada * 100) / getMetaDeHidratacion;
            llenos = porcentajeMeta / 5;
        }
        int vacios = 20 - llenos;
        return "[ " + "=".repeat(llenos) + "-".repeat(vacios) + "]" + " " + porcentajeMeta + "%"; 
    }
    
    /*
     * Unos pequeños metodos conveniente que me da el valor de Meta y Acumulado del modelo ControlDeHidratacion
     * para evitar que la vista (VistaControlDeHidratacion) toque el modelo directamente
     * lo que segun he visto son buenas practicas de programacion
     *
     * 
     * tambien lo use en metodos que necesiten mostrar este valor
     */
    public int getMetaDeHidratacion(){
        return controlHidratacion.getMetaDeHidratacion();
    }
    public int getAguaAcumulada(){
        return controlHidratacion.getAguaAcumulada();
    }
    public LocalDate getFecha() {
        return controlHidratacion.getFecha(); 
    }




}
