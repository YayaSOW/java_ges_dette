package org.example.core.database.impl;

import org.example.core.database.Database;
import org.example.data.entities.Client;

import java.sql.*;

public class DatabaseImp implements Database {
    protected Connection conn = null;
    protected PreparedStatement ps;
    protected String className = "com.mysql.cj.jdbc.Driver";
    protected String url = "jdbc:mysql://localhost:3306/ges_dette";
    protected String user = "root";
    protected String password = "";

    @Override
    public void getConnection() {
        try {
            Class.forName(className);
            if (conn == null) {
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void closeConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    //    public ResultSet executeQuery(String req) {
//        ResultSet rs = null;
//        try {
//            Statement stmt = conn.createStatement();
//            rs = stmt.executeQuery(req);
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
//        return rs;
//    }
    @Override
    public ResultSet executeQuery() throws SQLException {
        return ps.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        return ps.executeUpdate();
    }

    @Override
    public void initPreparedStatement(String sql) throws SQLException {
         if (sql.toUpperCase().trim().startsWith("INSERT")){
        ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         }
         else {
         ps = conn.prepareStatement(sql);
         }
    }
}
