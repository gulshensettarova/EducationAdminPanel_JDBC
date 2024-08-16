package org.example.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PostgresConfig {
    private static HikariDataSource dataSource;

    private final static String URL="jdbc:postgresql://localhost:5432/education";
    private final static String USER="postgres";
    private final static String PASSWORD="2810";

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.setMaximumPoolSize(20);
        config.setMinimumIdle(5); // Minimum boş əlaqə sayı
        config.setIdleTimeout(30000); // Boşda olan əlaqələrin maksimum qalma müddəti
        config.setMaxLifetime(1800000);
        dataSource = new HikariDataSource(config);
    }
    private static Connection connection;
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void closeDataSource() {
        if (dataSource != null && !dataSource.isClosed()) {
            dataSource.close();
        }
    }
}
