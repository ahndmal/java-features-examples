package com.anma.java.core.sql;

import com.anma.java.PropertiesConfig;

import java.sql.*;
import java.time.LocalDateTime;

public class PreparedStatementExe {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        PreparedStatement preparedStatement = ConnectionExe.getConnection().prepareStatement("INSERT INTO blogs VALUES ?, ?, ?, ?, ?");

        preparedStatement.setInt(1, 2);
        preparedStatement.setString(2, "some new body of the new blog ...");
        preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
        preparedStatement.setString(4, "Programming in 2020");
        preparedStatement.setInt(5, 1);

        System.out.println(preparedStatement.execute());



    }
}
