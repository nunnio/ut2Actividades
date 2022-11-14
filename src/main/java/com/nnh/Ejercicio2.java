package com.nnh;

import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner sc = null;
    public static void menu(){
        int sel;
        sc = new Scanner(System.in);
        while(true){
            System.out.println("\n\t-- Menu result set --\n1- Introducir una partitura\n2- Mostrar una partitura\n3- Mostrar todas las partituras\n4- Editar la primera partitura\n5- Borrar la última partitura\n6- Salir");
            sel = sc.nextInt();
            switch(sel){
                case 1: introPart();break;
                case 2: mostraPart();break;
                case 3: mostraAll();break;
                case 4: editaPart();break;
                case 5: borraPart();break;
                default: break;
            }
        }
    }
    public static void introPart(){

    }
    public static void mostraPart(){

    }
    public static void mostraAll(){

    }
    public static void editaPart(){

    }
    public static void borraPart(){

    }
    public static void insercion(Connection connection, Statement stmt, String qry, ConnectionPool connectionPool) {
        qry = "INSERT INTO nuno VALUES (" +
                "200, 1978, 'Rubén Bkades, Willie Colón', 'pedro navaja');" +
                "INSERT INTO nuno VALUES (" +
                "300, 2004, 'Philip Sparke', 'Harlequin');" +
                "INSERT INTO nuno VALUES (" +
                "400, 1988, 'Alfred Reed', 'Praise Jerusalem!');" +
                "INSERT INTO nuno VALUES (" +
                "500, 2017, 'Christopher Larkin', 'False knight');" +
                "INSERT INTO nuno VALUES (" +
                "600, 2017, 'Kristopher Maddigan', 'Honeycomb Herald');";
        qry = "INSERT INTO nuno(ID, ANIO, AUTOR, TITULO) VALUES (DEFAULT, ?, ?, ?)";
        try(Ejercicio6.getInstance(connectionPool).getConnection();
        stmt = ) {

        }

    }
}
