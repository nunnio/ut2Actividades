package com.nnh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio01 {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/nuno","root", "root");
            Statement stmt = connection.createStatement();
            String qry = "CREATE TABLE public.PARTITURA(" +
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
