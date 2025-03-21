package com.vti.utils;

import java.sql.*;

public class JBDCConnection {
    public static void main(String[] args) throws SQLException {
        String UrlConnection = "jdbc:mysql://localhost:3306/railway92";
        String userName = "root";
        String password = "35351325";
// tao connection tu app xuong database
        Connection connection = DriverManager.getConnection(UrlConnection, userName, password);

        if(connection!= null){
            System.out.println("Connection ok! Done");
        }else{
            System.out.println("Connection Error");
        }

        // Tạo đối tượng Statement cho phép thực hiện Query
        Statement statement = connection.createStatement();
        String sql = "Select *from accounts;";
        // Tạo đối tượng ResultSet để hứng kết quả truy vấn của câu Query(select)
        ResultSet rs = statement.executeQuery(sql);
        // Duyệt toàn bộ danh sách của ResultSet.
        // next() hiện thị xem có dữ liệu hay không.
        while(rs.next()){
            // getInt : lấy giá trị id theo Index từ 1,2,3
            int id = rs.getInt(1);
            //lấy id theo column name
            int id2 = rs.getInt("id");
            String pass = rs.getString("password");
            String username = rs.getString("username");
            System.out.println("ket qua: " + id2 + " | " + username + " | " + pass);
        }
        rs.close();
        String sqlInsert = "insert into accounts (username, password, lastname, firstname";


    }
}
