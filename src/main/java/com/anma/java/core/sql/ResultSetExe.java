package com.anma.java.core.sql;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetExe {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        ResultSet resultSet = ConnectionExe.getConnection().prepareStatement("select * from blogs").executeQuery();

        ResultSetMetaData metaData = resultSet.getMetaData();

        int columnsCount = metaData.getColumnCount();

        while (resultSet.next()) {

            for (int i = 1; i < columnsCount + 1; i++) {
                System.out.println(resultSet.getString(metaData.getColumnName(i)));
            }
        }
    }
}
