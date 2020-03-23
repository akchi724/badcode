package ru.liga.intership.badcode.service;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnector {
    private String url = "jdbc:hsqldb:mem:test";
    private String userName = "sa";
    private String password = "";

    public Statement getStatement() throws SQLException {
        return DriverManager.getConnection(url, userName, password).createStatement();
    }

    public ResultSet getExecuteQuery( Statement statement) throws SQLException {
        return statement.executeQuery("SELECT * FROM person WHERE sex = 'male' AND age > 18");
    }
}
