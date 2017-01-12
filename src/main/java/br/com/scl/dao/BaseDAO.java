package br.com.scl.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {

    public BaseDAO() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/scl";
        Connection conn = DriverManager.getConnection(url, "scluser", "scluser");
        return conn;
    }

}
