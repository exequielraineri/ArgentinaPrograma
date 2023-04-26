package com.mycompany.clases;

import com.gm.modelos.*;

/**
 *
 * @author ADMIN
 */
public class Partido {

    private Equipo equipo_1;
    private Equipo equipo_2;
    private int golesEquipo_1;
    private int golesEquipo_2;

    public Partido(Equipo equipo_1, Equipo equipo_2, int golesEquipo_1, int golesEquipo_2) {
        this.equipo_1 = equipo_1;
        this.equipo_2 = equipo_2;
        this.golesEquipo_1 = golesEquipo_1;
        this.golesEquipo_2 = golesEquipo_2;
    }

    public Partido() {
    }

    public Equipo getEquipo_1() {
        return equipo_1;
    }

    public void setEquipo_1(Equipo equipo_1) {
        this.equipo_1 = equipo_1;
    }

    @Override
    public String toString() {
        return "Partido{" + "equipo_1=" + equipo_1 + ", equipo_2=" + equipo_2 + ", golesEquipo_1=" + golesEquipo_1 + ", golesEquipo_2=" + golesEquipo_2 + '}';
    }

    public Equipo getEquipo_2() {
        return equipo_2;
    }

    public void setEquipo_2(Equipo equipo_2) {
        this.equipo_2 = equipo_2;
    }

    public int getGolesEquipo_1() {
        return golesEquipo_1;
    }

    public void setGolesEquipo_1(int golesEquipo_1) {
        this.golesEquipo_1 = golesEquipo_1;
    }

    public int getGolesEquipo_2() {
        return golesEquipo_2;
    }

    public void setGolesEquipo_2(int golesEquipo_2) {
        this.golesEquipo_2 = golesEquipo_2;
    }

    public String mostrarPartido() {

        return (String.format("%-20s %-15s %-15s %-20s",
                getEquipo_1().getNombre(), getGolesEquipo_1(), getGolesEquipo_2(), getEquipo_2().getNombre()));
    }

    public ResultadoEnum resultadoPartido() {
        if (getGolesEquipo_1() == golesEquipo_2) {
            return ResultadoEnum.empate;
        } else if (getGolesEquipo_1() > golesEquipo_2) {
            return ResultadoEnum.ganaEquipo1;
        } else {
            return ResultadoEnum.ganaEquipo2;
        }
    }

    
    
}
