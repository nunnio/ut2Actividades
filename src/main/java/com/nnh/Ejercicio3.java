package com.nnh;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
    public static void insercionSusceptible(Statement stmt, String qry, ResultSet rs){
        qry = "SELECT * FROM nuno";
        try {
            rs = stmt.executeQuery(qry);
            rs.absolute(5);
            rs.updateInt(2,2020);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void insercionNoSusceptible(PreparedStatement pstmt, String qry, ResultSet rs){
        qry = "SELECT * FROM nuno";
        try {
            rs = pstmt.executeQuery(qry);
            rs.absolute(5);
            rs.updateInt(2,2022);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
