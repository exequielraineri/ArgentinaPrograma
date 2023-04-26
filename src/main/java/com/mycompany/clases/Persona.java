/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;

/**
 *
 * @author ADMIN
 */
public class Persona {

    private int cantAciertos;
    private String nombre;
    private int puntaje;

    public Persona(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public int getCantAciertos() {
        return cantAciertos;
    }

    public void setCantAciertos(int cantAciertos) {
        this.cantAciertos = cantAciertos;
    }

    public Persona() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public void sumarPuntos(int puntosASumar) {
        this.puntaje += puntosASumar;
    }

}
