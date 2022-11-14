package com.nnh;

import org.apache.commons.dbcp.BasicDataSource;
import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BasicDataSource bds = null;
        String qry = null;
        ConnectionPool connectionPool = null;
        int sel;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        Ejercicio6.ConnectionPool(bds, qry);
        Ejercicio6.getInstance(connectionPool);
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/nuno","root", "root");
            PreparedStatement pstmt = null;
            Statement stmt = null;

            System.out.println("Creando base de datos con nombre nuno...");
            Ejercicio1.creaBBDD();
            System.out.println("Creando tabla partitura...");
            Ejercicio1.creaTabla(connection, stmt, qry, connectionPool);

            Ejercicio2.menu();

            System.out.println("Insertando information a tablas...");
            Ejercicio2.insercion(connection, pstmt, qry, connectionPool);
            qry = "SELECT * FROM nuno;";
            rs = pstmt.executeQuery(qry);
            rs.beforeFirst();
            rs = pstmt.executeQuery(Ejercicio2.insercion1(connection, pstmt));
            int n = 3;
            while(n>0 && n<6){
                System.out.println("Introduce la posición que desees cambiar");
                n = sc.nextInt();
            }
            rs.absolute(n);


        } catch (SQLException e) {
            e.printStackTrace();
        }



    }
}
