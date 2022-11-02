package com.nnh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

// En este ejercicio creamos la base de datos partituras. Para conectarme a ella lo haré en la clase Ejercicio01
public class Ejercicio1 {
    public static void creaBBDD(){
        try {
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/postgres", "root", "root");
            String qr = "CREATE DATABASE NUNO;";
            Statement stmt = conexion.createStatement();
            stmt.executeQuery(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void creaTabla(Connection connection, Statement stmt, String qry){
        try {
            stmt = connection.createStatement();
            qry = "CREATE TABLE public.PARTITURA(" +
                    "ID INT NOT NULL," +
                    "ANIO INT," +
                    "AUTOR CHARACTER VARYING(30)," +
                    "TITULO CHARACTER VARYING(30));";
            stmt.executeQuery(qry);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
