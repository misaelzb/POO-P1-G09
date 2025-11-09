package com.espol.modelo;

import java.time.LocalDate;

public class RegistroSostenibilidad {
    private LocalDate fecha;
    private String[] accionesRealizadas;
    private int puntosObtenidos;

    public RegistroSostenibilidad(LocalDate fecha, String[] accionesRealizadas, int puntosObtenidos) {
        this.fecha = fecha;
        this.accionesRealizadas = accionesRealizadas;
        this.puntosObtenidos = puntosObtenidos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String[] getAccionesRealizadas() {
        return accionesRealizadas;
    }

    public int getPuntosObtenidos() {
        return puntosObtenidos;
    }
}