package com.magnum.finance.config;

import com.magnum.finance.exceptions.DatabaseUnreachableException;
import lombok.extern.java.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;

@Log
public class PostgreSQLConfig {
    private static Connection connection = null;
    private static final String URL = "jdbc:postgresql://localhost:5432/finance";
    private static final String USER = "finance";
    private static final String PASSWORD = "finance";
    public static Connection createConnection() throws DatabaseUnreachableException {
        try {
            if (connection != null) {
                Class.forName("org.postgresql.Driver");
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            }
            return connection;
        } catch (ClassNotFoundException | SQLException e) {
            log.log(Level.SEVERE, "Could not connect to the database {}", e.getMessage());
            throw new DatabaseUnreachableException("Could not connect to the database", e);
        }
    }

    public static void closeConnection() throws DatabaseUnreachableException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.log(Level.SEVERE, "Could not close the database connection {}", e.getMessage());
            throw new DatabaseUnreachableException("Could not close the database connection", e);
        }
    }

}
