package com.nnh;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        int sel;
        Scanner sc = new Scanner(System.in);
        try {
            Connection connection = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/nuno","root", "root");
            Statement stmt = connection.createStatement();
            String qry = null;
            System.out.println("Creando base de datos con nombre nuno...");
            Ejercicio1.creaBBDD();
            System.out.println("Creando tabla partitura...");
            Ejercicio1.creaTabla(connection, stmt, qry);
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
