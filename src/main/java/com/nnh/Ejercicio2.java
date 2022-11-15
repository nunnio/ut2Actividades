package com.nnh;

import java.sql.*;
import java.util.Scanner;

public class Ejercicio2 {
    static Scanner sc = null;
    public static void menu(Statement stmt, ResultSet rs, String qry){
        int sel;
        sc = new Scanner(System.in);
        while(true){
            System.out.println("\n\t-- Menu result set --\n1- Introducir una partitura\n2- Mostrar una partitura\n3- Mostrar todas las partituras\n4- Editar la primera partitura\n5- Borrar la última partitura\n6- Salir");
            sel = sc.nextInt();
            qry = "SELECT * FROM nuno";
            switch(sel){
                case 1: introPart(stmt, rs, qry);break;
                case 2: mostraPart(stmt, rs, qry);break;
                case 3: mostraAll(stmt, rs, qry);break;
                case 4: editaPart(stmt, rs, qry);break;
                case 5: borraPart(stmt, rs, qry);break;
                default: break;
            }
        }
    }
    public static void introPart(Statement stmt, ResultSet rs, String qry){
        try {
            rs = stmt.executeQuery(qry);
            rs.moveToInsertRow();
            //rs.updateInt(1,600);
            rs.updateInt(2, 3322);
            rs.updateString(3, "Tirano");
            rs.updateString(4, "Persuasive");
            rs.insertRow();
            System.out.println("Partitura insertada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void mostraPart(Statement stmt, ResultSet rs, String qry){

        System.out.println("Introduce la posición que quieras mostrar");
        int sel = sc.nextInt();
        try {
            rs = stmt.executeQuery(qry);
            rs.absolute(sel);
            System.out.println(rs.getInt(1+" "));
            System.out.println(rs.getInt(2+" "));
            System.out.println(rs.getString(3+" "));
            System.out.println(rs.getString(4+" \n"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void mostraAll(Statement stmt, ResultSet rs, String qry){
        try{
            rs = stmt.executeQuery(qry);
            while(rs.next()){
                System.out.println(rs.getInt(1+" "));
                System.out.println(rs.getInt(2+" "));
                System.out.println(rs.getString(3+" "));
                System.out.println(rs.getString(4+" \n"));

            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
    public static void editaPart(Statement stmt, ResultSet rs, String qry){
        try {
            rs = stmt.executeQuery(qry);
            rs.first();
            rs.updateInt(2,2022);
            rs.updateString(3,"SZA");
            rs.updateRow();
            System.out.println("Partitura actualizada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void borraPart(Statement stmt, ResultSet rs, String qry){
        try {
            rs = stmt.executeQuery(qry);
            rs.last();
            rs.deleteRow();
            System.out.println("Partitura borrada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void insercion(Connection connection, PreparedStatement pstmt, String qry) {
        qry = "INSERT INTO nuno(ID, ANIO, AUTOR, TITULO) VALUES (?, ?, ?, ?)";
        try {
            pstmt = connection.prepareStatement(qry);
            pstmt.setInt(1,100);
            pstmt.setInt(2, 1978);
            pstmt.setString(3, "Rubén Bkades, Willie Colón");
            pstmt.setString(4, "pedro navaja");

            pstmt.setInt(1,200);
            pstmt.setInt(2, 2004);
            pstmt.setString(3, "Philip Sparke");
            pstmt.setString(4, "Harlequin");

            pstmt.setInt(1,300);
            pstmt.setInt(2, 1988);
            pstmt.setString(3, "Alfred Reed");
            pstmt.setString(4, "Praise Jerusalem!");

            pstmt.setInt(1,400);
            pstmt.setInt(2, 2017);
            pstmt.setString(3, "Christopher Larkin");
            pstmt.setString(4, "False knight");

            pstmt.setInt(1,500);
            pstmt.setInt(2, 2017);
            pstmt.setString(3, "Kristopher Maddigan");
            pstmt.setString(4, "Honeycomb Herald");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pstmt!=null)
                    pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
