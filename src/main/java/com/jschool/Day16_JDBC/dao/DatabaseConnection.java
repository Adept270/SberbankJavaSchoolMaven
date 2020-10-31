package com.jschool.Day16_JDBC.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    static final String URL = "jdbc:h2:tcp://localhost/~/test";
    static final String USERNAME = "sa";
    static final String PASSWORD = "";

    private DatabaseConnection() {
        try {
            Class.forName("org.h2.Driver");
            this.connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database Connection Creation Failed : \" + ex.getMessage()");
        }
    }

    public Connection getConnection() {
        return connection;

    }

    public void closeConnection(Connection connection) throws SQLException {
        if (!connection.isClosed()) {
            connection.close();
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
