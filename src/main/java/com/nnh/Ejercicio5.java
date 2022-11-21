package com.nnh;

import java.sql.*;

public class Ejercicio5 {
    public static void procedimiento(String qry, CallableStatement cstmt, Connection connection){
        qry = "call borraPartituras()";
        try {
            cstmt = connection.prepareCall(qry);
            cstmt.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void funcion(String qry, PreparedStatement pstmt, Connection connection, ResultSet rs){
        qry = "select public.cuentaPartituras()";
        try {
            pstmt = connection.prepareStatement(qry);
            rs = pstmt.executeQuery();
            rs.next();
            if(rs.wasNull()){
                System.out.println("No hay partituras");
            }
            else{
                int i = rs.getInt(1);
                System.out.println("Actualmente hay "+i+" partuturas");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
