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
            Statement stmt = connection.createStatement();

            System.out.println("Creando base de datos con nombre nuno...");
            Ejercicio1.creaBBDD();
            System.out.println("Creando tabla partitura...");
            Ejercicio1.creaTabla(connection, stmt, qry);
            System.out.println("Insertando información a tablas...");
            Ejercicio2.insercion(connection, stmt, qry);
            qry = "SELECT * FROM nuno;";
            rs = stmt.executeQuery(qry);
            rs.beforeFirst();
            rs = stmt.executeQuery(Ejercicio2.insercion1(connection, stmt));
            int n = 3;
            while(n>0 && n<6){
                System.out.println("Introduce la posición que desees cambiar");
                n = sc.nextInt();
            }
            rs.absolute(n);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        /*while(true){
            System.out.println("Introduce la acción que desee: " +
                    "1- Crear base de datos" +
                    "2- Modificar tabla" +
                    "3- Borrar tabla" +
                    "0- Salir");
            sel = sc.nextInt();
            switch (sel){
                case 1: insertar(); break;
                case 2: modificar(); break;
                case 3: borrar(); break;
                default:
                    System.out.println("Saliendo del programa");
                    System.exit(0);
            }
        }*/


    }
}
