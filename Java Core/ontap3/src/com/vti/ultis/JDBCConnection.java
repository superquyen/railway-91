package com.vti.ultis;

import java.sql.*;

public class JDBCConnection {
    private static Connection connection = null;
    private static PreparedStatement pstmt = null;
    private static ResultSet rs = null;

    private static final String URL = "jdbc:mysql://localhost:3306/finalexam1";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "35351325";

    // Đảm bảo chỉ có một instance duy nhất
    public static Connection getInstance() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Connection established successfully!");
        }
        return connection;
    }

    // Lấy kết nối (tương thích với code cũ)
    public static Connection getConnection() throws SQLException {
        return getInstance();
    }

    // Đóng kết nối và tài nguyên JDBC
    public static void closeConnection() {
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("Connection closed successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
