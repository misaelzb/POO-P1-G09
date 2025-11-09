package com.espol.controlador;


public class InicializarApp {
    public InicializarApp(){
    }
    //Para que se guarden registros al iniciar app
    public void iniciar(ControladorControlDeHidratacion controlador_Hidratacion){
        controlador_Hidratacion.CrearRegistros(100, 2500, 9, 30);
        controlador_Hidratacion.CrearRegistros(100, 11, 30);
    }
}
