/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.gm.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class Conexion {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/pronostico?autoReconnect=true&useSSL=false";
        String username = "root";
        String password = "root";

        Connection con = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Conexion exitosa");

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion a base de datos");
            System.out.println(e.getMessage());
        }
        return con;
    }

}
