package com.vti.backend.data;

import com.vti.entity.Account;
import com.vti.frontend.Main;
import com.vti.utils.JDBCConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    public boolean login(String username, String password) throws SQLException {
//        if(username.equals("sonny") && password.equals("123456")){
//            return true;
//        }else{
//            return false;
//        }
        Connection connection = JDBCConnection.getConnection();
        String sql = "Select * from accounts where username = ? and password = ?";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, username);
        pstmt.setString(2, password);
        ResultSet rs = pstmt.executeQuery();
        if(rs.next()){
            System.out.println("ton tai user, login thanh cong");
            Main.isLogin = true;
            return  true;
        }else{
            System.out.println("login that bai, khong ton tai user");
            return false;
        }

    }
    public List<Account> getListAccounts() throws SQLException {
        Connection connection = JDBCConnection.getConnection();
        String sql = "SELECT * FROM accounts";
        PreparedStatement pstmt = connection.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<Account> listAccounts = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("id");
            String username = rs.getString("username");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            int department_id = rs.getInt("department_id");
            Account account = new Account(id, username, lastname, password, department_id);
            listAccounts.add(account);
        }
    return null;
    }
}
