package com.nnh;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class Ejercicio2 {
    public static void insercion(Connection connection, Statement stmt, String qry) {
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

    }
    public static String insercion1(Connection connection, Statement stmt) {
        return "INSERT INTO nuno VALUES (" +
                "100, 1990, 'Motoi Sakuraba', 'Kings' Boards');";

    }
    public static String modificacion(Connection connection, Statement stmt){
        return "ALTER TABLE ";
    }
}
