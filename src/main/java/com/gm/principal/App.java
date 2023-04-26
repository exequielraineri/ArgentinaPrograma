/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.principal;

import com.gm.config.Conexion;
import com.mycompany.clases.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ADMIN
 */
public class App {

    List<Persona> personas = new ArrayList<>();
    List<Pronostico> pronosticos = new ArrayList<>();
    List<Partido> partidos = new ArrayList<>();

    public void menu() {

        leerArchivoResultados();

        leerBaseDeDatos();

        calcularPuntos();

        mostrarPuntuacion();

    }

    private void leerArchivoResultados() {
        try {
            BufferedReader leer = new BufferedReader(new FileReader("resultados.csv"));
            String linea = leer.readLine();
            String[] datos;

            while ((linea = leer.readLine()) != null) {
                datos = linea.split(";");

                Equipo equipo_1 = new Equipo(datos[2]);
                int golesEquipo1 = Integer.parseInt(datos[3]);
                int golesEquipo2 = Integer.parseInt(datos[4]);
                Equipo equipo_2 = new Equipo(datos[5]);

                Partido partido = new Partido(equipo_1, equipo_2, golesEquipo1, golesEquipo2);
                partidos.add(partido);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void leerBaseDeDatos() {
        try {
            Conexion con = new Conexion();
            System.out.println("conexion: " + con.getConnection().getCatalog());

            String sql = "SELECT * FROM pronosticos";

            PreparedStatement ps = con.getConnection().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            Pronostico pronostico;
            while (rs.next()) {
                pronostico = new Pronostico();
                pronostico.setFase(rs.getInt("fase"));
                pronostico.setRonda(rs.getInt("ronda"));
                pronostico.setEquipo_1(rs.getString("equipo_1"));
                pronostico.setEquipo_2(rs.getString("equipo_2"));
                pronostico.setPersona(rs.getString("persona"));
                pronostico.setGanaEquipo1(rs.getBoolean("gana_1"));
                pronostico.setGanaEquipo2(rs.getBoolean("gana_2"));
                pronostico.setEmapte(rs.getBoolean("empate"));

                pronosticos.add(pronostico);
            }

        } catch (SQLException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void calcularPuntos() {

        for (Pronostico pronostico : pronosticos) {
            for (Partido partido : partidos) {
                if ((pronostico.getEquipo_1().equals(partido.getEquipo_1().getNombre()))
                        && (pronostico.getEquipo_2().equals(partido.getEquipo_2().getNombre()))) {
                    if (pronostico.isGanaEquipo1() && partido.getGolesEquipo_1() > partido.getGolesEquipo_2()) {
                        pronostico.sumarPuntos(5);
                    } else if (pronostico.isEmapte() && partido.getGolesEquipo_1() == partido.getGolesEquipo_2()) {
                        pronostico.sumarPuntos(5);
                    } else if (pronostico.isGanaEquipo2() && partido.getGolesEquipo_2() > partido.getGolesEquipo_1()) {
                        pronostico.sumarPuntos(5);
                    }
                }
            }

        }
    }

    public void mostrarPuntuacion() {
        System.out.println("Puntuación de los pronósticos:");
        Map<String, Integer> puntajesTotales = new HashMap<>();
        for (Pronostico pronostico : pronosticos) {
            String persona = pronostico.getPersona();
            int puntos = pronostico.getPuntos();
            puntajesTotales.put(persona, puntajesTotales.getOrDefault(persona, 0) + puntos);
        }
        for (Map.Entry<String, Integer> puntaje : puntajesTotales.entrySet()) {
            System.out.println(puntaje.getKey() + ": " + puntaje.getValue() + " puntos.");
        }
    }

    public void listarPersonas() {
        System.out.println("\n\nlistando");
        for (Persona persona : personas) {
            System.out.println("Nombre: " + persona.getNombre() + ""
                    + "\nAciertos: " + persona.getCantAciertos() + ""
                    + "\nPuntos: " + persona.getPuntaje());
            System.out.println("\n");
        }
    }

    public void agregarPersona(Persona persona) {
        Persona p = null;
        boolean existe = false;
        for (Persona per : personas) {
            if (per.getNombre().equals(persona.getNombre())) {
                p = per;
                existe = true;
            }
        }

        if (existe == false) {
            personas.add(new Persona(persona.getNombre(), +2));
        }
    }
}
