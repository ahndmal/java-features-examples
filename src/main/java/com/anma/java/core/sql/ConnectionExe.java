package com.anma.java.core.sql;

import com.anma.java.PropertiesConfig;

import java.sql.*;

public class ConnectionExe {

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        return DriverManager.getConnection(PropertiesConfig.getProperty(PropertiesConfig.DB_URL),
                PropertiesConfig.getProperty(PropertiesConfig.DB_LOGIN),
                PropertiesConfig.getProperty(PropertiesConfig.DB_PASSWORD));
    };

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");

//        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/blogs-2", "developer", "porkie");
        Connection connection = getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("select * from blogs");

        ResultSet resultSet = preparedStatement.executeQuery();

        while(resultSet.next()) {
            System.out.println(resultSet.getInt("blog_id"));
            System.out.println(resultSet.getString("body"));
            System.out.println(resultSet.getString("title"));
            System.out.println(resultSet.getTimestamp("created_at"));
        }

        connection.close();

    }
}
