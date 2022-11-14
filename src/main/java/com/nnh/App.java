package com.nnh;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int sel;
        String qry = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/nuno","root", "root");
            PreparedStatement pstmt = null;
            Statement stmt = null;

            System.out.println("Creando base de datos con nombre nuno...");
            Ejercicio1.creaBBDD();
            System.out.println("Creando tabla partitura...");
            Ejercicio1.creaTabla(connection, stmt, qry);

            Ejercicio2.menu();

            System.out.println("Insertando information a tablas...");
            Ejercicio2.insercion(connection, pstmt, qry);
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
