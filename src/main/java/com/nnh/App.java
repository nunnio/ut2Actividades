package com.nnh;

import org.apache.commons.dbcp.BasicDataSource;
import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.*;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        BasicDataSource bds = null;
        PreparedStatement pstmt = null;
        Statement stmt = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);
        int sel;
        String qry = null;
        Connection connection = null;
        CallableStatement cstmt = null;

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://172.18.0.2:5432/nuno","root", "root");
            stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            pstmt = connection.prepareStatement(String.valueOf(ResultSet.TYPE_SCROLL_INSENSITIVE), ResultSet.CONCUR_UPDATABLE);
            System.out.println("Creando base de datos con nombre nuno...");
            Ejercicio1.creaBBDD();
            System.out.println("Creando tabla partitura...");
            Ejercicio1.creaTabla(connection, stmt, qry);

            System.out.println("Insertando information a tablas...");
            Ejercicio2.insercion(connection, pstmt, qry);
            Ejercicio2.menu(stmt, rs, qry);
            Ejercicio3.insercionSusceptible(stmt, qry, rs);
            Ejercicio3.insercionNoSusceptible(pstmt, qry, rs);
            Ejercicio4.transaccion(stmt, qry, rs, connection);
            Ejercicio5.funcion(qry, pstmt, connection, rs);
            Ejercicio5.procedimiento(qry, cstmt, connection);

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                //rs.close();
                connection.close();
                pstmt.close();
                stmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }



    }
}
