package com.company;

import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class SQLConnect {
    private Connection connection = null;

    public SQLConnect() throws Exception {
        makeConnection();
    }

    private void makeConnection() {
        try {
            connection = getConnection(
                    "jdbc:mysql://localhost:3306/gem_shop",
                    "user",
                    "12345");
        } catch (Exception e) {
            System.out.println("Sorry, something went wrong!");
            e.printStackTrace();
        }
        System.out.println("Welcome to Gemstones shop!");
    }

    public void getStones() throws SQLException {
        if (connection != null) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT name FROM stones;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString("name"));
            }
        }
    }
    public String idStone(String stone) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM stones;");
        while (resultSet.next()) {
            if (stone.equals(resultSet.getString("name"))) {
                return resultSet.getString("type");
            }
        }
        return "Hi";
    }
    public Precious getStone(String stone) throws SQLException {
        Statement statement = connection.createStatement();
        Precious ps = new Precious();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM stones where type = 'precious';");
        while (resultSet.next()) {
            if (stone.equals(resultSet.getString("name"))) {
                double weight = resultSet.getDouble("weight");
                double cost = resultSet.getDouble("car_cost");
                ps  = new Precious(stone, weight, cost);
                return ps;
            }
        }
        return ps;
    }
    public SemiPrecious getSemiStone(String stone) throws SQLException {
        Statement statement = connection.createStatement();
        SemiPrecious ps = new SemiPrecious();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM stones where type = 'semi-precious';");
        while (resultSet.next()) {
            if (stone.equals(resultSet.getString("name"))) {
                String name = resultSet.getString("name");
                double weight = resultSet.getDouble("weight");
                double cost = resultSet.getDouble("car_cost");
                ps  = new SemiPrecious(name, weight, cost);
                return ps;
            }
        }
        return ps;
    }
}
