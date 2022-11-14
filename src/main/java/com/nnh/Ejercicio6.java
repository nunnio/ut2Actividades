package com.nnh;
import org.apache.commons.dbcp.BasicDataSource;
import org.postgresql.jdbc2.optional.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Ejercicio6 {

    public static void ConnectionPool(BasicDataSource bds, String qry){
        bds = new BasicDataSource();
        qry = "jdbc:postgresql://172.18.0.2:5432/nuno";
        PreparedStatement stmt = null;
        bds.setUrl(qry);
        bds.setUsername("root");
        bds.setPassword("root");
        bds.setMinIdle(5);
        bds.setMinIdle(10);
        bds.setMaxOpenPreparedStatements(1000);
    }
    public static ConnectionPool getInstance(ConnectionPool connectionPool){
        if(connectionPool == null){
            connectionPool = new ConnectionPool();
        }
        return new ConnectionPool;
    }
    public static Connection getConnection(BasicDataSource bds){
        Connection connection = null;
        try{
            connection = bds.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    public static void closeConnection(Connection connection){
        try {
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
