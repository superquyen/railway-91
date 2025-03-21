package com.vti.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCConnection4 {
    public static void main(String[] args) throws IOException, SQLException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("./src/com/vti/resource/database.properties"));

        String urlConnection = properties.getProperty("urlConnection");
        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        Connection connection = DriverManager.getConnection(urlConnection, username, password);
        System.out.println("Connection success");

        String sql = "{call GetListAllUser()}";
        CallableStatement cstmt = connection.prepareCall(sql);
        ResultSet rs = cstmt.executeQuery();
        while(rs.next()){
            String username1 = rs.getString("username");
            String pass = rs.getString("password");
            System.out.println(username1 + " " + pass);

        }

        String sql2 = "{call GetListUserById(?)}";
        CallableStatement cstmt2 = connection.prepareCall(sql2);
        cstmt2.setInt(1, 1);
        ResultSet rs2 = cstmt2.executeQuery();
        while(rs2.next()) {
            String username2 = rs2.getString("username");
            String pass2 = rs2.getString("password");
            System.out.println(username2 + " " + pass2);
        }
        rs2.close();
    }

}
