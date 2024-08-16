package org.example.config;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresConfig {

    private final static String URL="jdbc:postgresql://localhost:5432/education";
    private final static String USER="postgres";
    private final static String PASSWORD="2810";

    private static Connection connection;
    public static Connection getConnection() {
        try{
            if(connection==null){
                connection=DriverManager.getConnection(URL,USER,PASSWORD);
            }
            return connection;
        }
        catch(SQLException e){
            throw new RuntimeException(e);
        }

    }
}
