/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectopronostico;

import com.mycompany.clases.Equipo;
import com.mycompany.clases.Participante;
import com.mycompany.clases.Partido;
import com.mycompany.clases.Pronostico;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProyectoPronostico {

    public static void main(String[] args) {
        List<Partido> partidos = new ArrayList<>();
        List<Pronostico> pronosticos = new ArrayList<>();
        int op;
        Scanner sc = new Scanner(System.in);
        do {
            menuDeOpciones();
            System.out.print("\tIngrese Opcion: ");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Leyendo Resultados...");
                    partidos = leerResultados();
                    break;
                case 2:

                    System.out.println("Leyendo Pronosticos...");
                    calcularPronostico(partidos);
                    break;
                case 3: {
                    if (partidos.isEmpty()) {
                        System.out.println("Debe leer el archivo!");
                    } else {
                        verPartidos(partidos);
                    }
                    break;
                }
            }

        } while (op != 0);

    }

    private static void menuDeOpciones() {
        System.out.println("\n\tMenu Principal"
                + "\n\t1. Leer Archivo Resultados.csv"
                + "\n\t2. Calcular Pronosticos"
                + "\n\t3. Ver Partidos"
                + "\n\t0. Salir"
                + "\n\t---------------------------------");
    }

    private static void verPartidos(List<Partido> partidos) {

        System.out.println(String.format("%-5s %-20s %-20s %-20s %-20s", "Ronda", "Equipo 1", "Goles Equipo 1", "Goles Equipo 2", "Equipo 2"));
        for (int i = 0; i < partidos.size(); i++) {
            System.out.println(String.format("%-5s %-20s %-20s %-20s %-20s", 1, partidos.get(i).getEquipo1().getNombre(), partidos.get(i).getGolesEquipo1(), partidos.get(i).getGolesEquipo2(), partidos.get(i).getEquipo2().getNombre()));
        }
    }

    private static List<Partido> leerResultados() {
        List<Partido> lista_partidos = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader("resultados.csv"));
            String linea = leer.readLine();
            String[] datos;
            Partido partido;
            while ((linea = leer.readLine()) != null) {

                datos = linea.split(";");
                for (int i = 0; i < datos.length; i++) {
                    System.out.print(datos[i]);
                }
                partido = new Partido();
                partido.setEquipo1(new Equipo(datos[1]));
                partido.setEquipo2(new Equipo(datos[4]));
                partido.setGolesEquipo1(Integer.parseInt(datos[2]));
                partido.setGolesEquipo2(Integer.parseInt(datos[3]));

                lista_partidos.add(partido);

            }
        } catch (Exception e) {
            System.out.println("e:" + e);

        }
        return lista_partidos;
    }

    private static List<Pronostico> calcularPronostico(List<Partido> partidos) {
        List<Participante> participantes = new ArrayList<>();
        List<Pronostico> lista_pronosticos = new ArrayList<>();
        try {
            BufferedReader leer = new BufferedReader(new FileReader("pronostico.csv"));
            String linea = leer.readLine();
            String[] datos;
            Pronostico pronostico = null;
            while ((linea = leer.readLine()) != null) {
                datos = linea.split(";");
                for (int i = 0; i < datos.length; i++) {
                    System.out.println(datos[i]);
                }

            }
        } catch (Exception e) {
            System.out.println("e:" + e);

        }
        return lista_pronosticos;
    }

}
