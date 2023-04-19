package com.mycompany.clases;

public class Participante {

    private String nombre;
    private int puntos;
    
    
    public Participante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Participante(String nombre) {
        this.nombre = nombre;
    }
    
    
}
