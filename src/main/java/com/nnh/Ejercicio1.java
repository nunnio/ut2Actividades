package com.nnh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// En este ejercicio creamos la base de datos partituras. Para conectarme a ella lo haré en la clase Ejercicio01
public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/postgres", "root", "root");
            String qr = "CREATE DATABASE NUNO;";
            Statement stmt = conexion.createStatement();
            stmt.executeQuery(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
