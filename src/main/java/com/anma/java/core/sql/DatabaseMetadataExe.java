package com.anma.java.core.sql;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetadataExe {

    public static void main(String[] args) throws SQLException, ClassNotFoundException {

        DatabaseMetaData databaseMetaData = ConnectionExe.getConnection().getMetaData();
        ResultSet schemas = databaseMetaData.getSchemas();
        while (schemas.next()) {
            System.out.println(schemas.getString("TABLE_SCHEM"));
            System.out.println(schemas.getString("TABLE_CATALOG"));
        }
    }
}
