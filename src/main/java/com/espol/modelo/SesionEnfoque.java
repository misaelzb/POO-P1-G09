package com.espol.modelo;

import java.time.LocalDate;

public class SesionEnfoque {
    private LocalDate fecha;
    private String tecnicaAplicada;
    private int duracionMinutos;

    public SesionEnfoque(LocalDate fecha, String tecnicaAplicada, int duracionMinutos) {
        this.fecha = fecha;
        this.tecnicaAplicada = tecnicaAplicada;
        this.duracionMinutos = duracionMinutos;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTecnicaAplicada() {
        return tecnicaAplicada;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }
}