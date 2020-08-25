package com.anma.java.core.sql;

import com.anma.java.PropertiesConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PreparedStatementExe {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        boolean result = new ConnectionExe().getConnection().createStatement().execute("select * from blogs");
        System.out.println(result);

    }
}
