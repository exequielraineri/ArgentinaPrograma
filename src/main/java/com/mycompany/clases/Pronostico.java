/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.clases;

import com.gm.modelos.*;

/**
 *
 * @author ADMIN
 */
public class Pronostico {

    private int fase;
    private int ronda;
    private String persona;
    private String equipo_1;
    private String equipo_2;
    private boolean ganaEquipo1;
    private boolean ganaEquipo2;
    private boolean emapte;
    ResultadoEnum resultado;

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public int getAciertos() {
        return aciertos;
    }

    public void setAciertos(int aciertos) {
        this.aciertos = aciertos;
    }

    private int puntos;
    private int aciertos;

    public Pronostico() {
    }

    public Pronostico(int fase, int ronda, String persona, String equipo_1, String equipo_2, boolean ganaEquipo1, boolean ganaEquipo2, boolean emapte) {
        this.fase = fase;
        this.ronda = ronda;
        this.persona = persona;
        this.equipo_1 = equipo_1;
        this.equipo_2 = equipo_2;
        this.ganaEquipo1 = ganaEquipo1;
        this.ganaEquipo2 = ganaEquipo2;
        this.emapte = emapte;
    }

    public int getFase() {
        return fase;
    }

    public void setFase(int fase) {
        this.fase = fase;
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
        aciertos++;
    }

    public int getRonda() {
        return ronda;
    }

    public void setRonda(int ronda) {
        this.ronda = ronda;
    }

    public String getPersona() {
        return persona;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public String getEquipo_1() {
        return equipo_1;
    }

    public void setEquipo_1(String equipo_1) {
        this.equipo_1 = equipo_1;
    }

    public String getEquipo_2() {
        return equipo_2;
    }

    public void setEquipo_2(String equipo_2) {
        this.equipo_2 = equipo_2;
    }

    public boolean isGanaEquipo1() {
        return ganaEquipo1;
    }

    public void setGanaEquipo1(boolean ganaEquipo1) {
        this.ganaEquipo1 = ganaEquipo1;
    }

    public boolean isGanaEquipo2() {
        return ganaEquipo2;
    }

    public void setGanaEquipo2(boolean ganaEquipo2) {
        this.ganaEquipo2 = ganaEquipo2;
    }

    public boolean isEmapte() {
        return emapte;
    }

    public void setEmapte(boolean emapte) {
        this.emapte = emapte;
    }

    public ResultadoEnum obtenerResultado() {
        if (isEmapte()) {
            return ResultadoEnum.empate;
        } else if (isGanaEquipo1()) {
            return ResultadoEnum.ganaEquipo1;
        } else if (isGanaEquipo2()) {
            return ResultadoEnum.ganaEquipo2;
        }
        return null;

    }

    public String mostrarPronostico() {

        return (String.format("%-20s %-20s %-20s %-20s %-20s %-20s %-20s %-20s",
                getFase(), getRonda(), getPersona(), getEquipo_1(), isGanaEquipo1(), isEmapte(), isGanaEquipo2(), getEquipo_2()));
    }

}
