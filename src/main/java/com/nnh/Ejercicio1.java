package com.nnh;

import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;

// En este ejercicio creamos la base de datos partituras. Para conectarme a ella lo haré en la clase Ejercicio01
public class Ejercicio1 {
    public static void creaBBDD(){
        try{
            Connection conexion = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/postgres", "root", "root");
            String qr = "CREATE DATABASE NUNO;";
            Statement stmt = conexion.createStatement();
            stmt.executeQuery(qr);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void creaTabla(Connection connection, Statement stmt, String qry){
        qry = "CREATE TABLE public.PARTITURA(" +
                "ID INT NOT NULL," +
                "ANIO INT," +
                "AUTOR CHARACTER VARYING(30)," +
                "TITULO CHARACTER VARYING(30));";
        try(connection = ConnectionPool.getInstance().getConnection();
        stmt = connection.createStatement();) {
            stmt.executeUpdate(qry);
            System.out.println("Tabla creada");
            ConnectionPool.getInstance().closeConnection(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
