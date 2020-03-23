package ru.liga.intership.badcode.service;


import ru.liga.intership.badcode.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonService {
    public void printAdultMaleUsersAverageBMI() throws SQLException {
        DataBaseConnector dataBaseConnector= new DataBaseConnector();
        System.out.println("Average IMT :"+getAdultMaleUsersAverageBMI(dataBaseConnector.getExecuteQuery(dataBaseConnector.getStatement())));
    }
    public double getAdultMaleUsersAverageBMI(ResultSet resultSet) throws SQLException {
        double totalImt = 0.0;
        int countOfPerson = 0;

        while (resultSet.next()) {
            totalImt += getImt(resultSet.getDouble("weight"),resultSet.getDouble("height"));
            countOfPerson++;
        }
        return totalImt / countOfPerson;
    }

    public double getImt(double weight,double height){
        return weight/Math.pow(getHeightInMeters(height),2);
    }

    public double getHeightInMeters(double height){
        return height/100d;
    }
}
