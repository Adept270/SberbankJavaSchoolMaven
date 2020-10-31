package com.jschool.Day16_JDBC.dao;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class DBTools {

    final Connection connection;

    public DBTools() throws SQLException {
        connection = DatabaseConnection.getInstance().getConnection();
        checkTableExist();
    }

    public Map<Integer, Integer> getFromDB() throws SQLException {
        Map<Integer, Integer> resultMap = new HashMap<>();
        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT * FROM FIBONACCI");
        while (resultSet.next()) {
            resultMap.put(resultSet.getInt(1), resultSet.getInt(2));
        }
        return resultMap;
    }

    public void setIntoDB(Map<Integer, Integer> map) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("INSERT INTO FIBONACCI VALUES(?,?)");
        map.forEach((key, value) -> {
            try {
                statement.setInt(value, 2);
                statement.setInt(key, 1);
                statement.addBatch();
            } catch (SQLException throwables) {
                System.out.println(throwables.getMessage());
            }
        });

        statement.executeBatch();

    }

    private void checkTableExist() {

        try {
            Statement statement = connection.createStatement();
            String createTableSQL = "CREATE TABLE IF NOT EXISTS FIBONACCI (ID INT PRIMARY KEY NOT NULL," +
                    " CALCRESULT INT NOT NULL";
            statement.executeUpdate(createTableSQL);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

