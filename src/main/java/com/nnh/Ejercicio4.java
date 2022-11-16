package com.nnh;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio4 {
    public static void transaccion(Statement stmt, String qry, ResultSet rs, Connection connection) {
        qry = "INSERT INTO nuno(ID, ANIO, AUTOR, TITULO) VALUES (?, ?, ?, ?)";

        try {
            connection.setAutoCommit(false);
            rs = stmt.executeQuery(qry);
            rs.moveToInsertRow();
            rs.updateInt(1,700);
            rs.updateInt(2, 2021);
            rs.updateString(3, "Paco Moreno");
            rs.updateString(4, "O algo así");
            rs.insertRow();
            rs.updateRow();
            System.out.println("Partitura insertada");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //Inserción errónea
        qry = "UPDATE nuno SET titulo=? WHERE titulo=?";
        try {
            rs = stmt.executeQuery(qry);
            rs.absolute(7);
            rs.updateString(1, "Desabrazarme de ti");
            rs.updateString(2, "Eterno balanseo");
            rs.updateRow();
            connection.commit();
        } catch (
                SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                connection.rollback();
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
