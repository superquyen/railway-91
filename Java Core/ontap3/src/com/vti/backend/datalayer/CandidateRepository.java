package com.vti.backend.datalayer;

import com.vti.entity.*;
import com.vti.ultis.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CandidateRepository implements ICandidateRepository {
    private Connection connection;

    public CandidateRepository() throws SQLException {
        this.connection = JDBCConnection.getConnection();
    }

    @Override
    public boolean registerE(String firstName, String lastName, String phone, String email, int expInYear, String proSkill, String password) {
        String sql = "INSERT INTO candidate (firstname, lastname, phone, email, password, exp_in_year, pro_skill, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.setInt(6, expInYear);
            statement.setString(7, proSkill);
            statement.setString(8, "EXPERIENCECANDIDATE");
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registerF(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank) {
        String sql = "INSERT INTO candidate (firstname, lastname, phone, email, password, graduation_rank, role) VALUES (?, ?, ?, ?, ?, ?, ?);";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, phone);
            statement.setString(4, email);
            statement.setString(5, password);
            statement.setString(6, graduationRank.toString()); // Chuyển GraduationRank thành String
            statement.setString(7, "FRESHERCANDIDATE");
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Candidate login(String email, String password) {
        String sql = "SELECT * FROM candidate WHERE email = ? AND password = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            statement.setString(2, password);
            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("id");
                    String firstName = rs.getString("firstname");
                    String lastName = rs.getString("lastname");
                    String phone = rs.getString("phone");
                    String role = rs.getString("role");

                    if ("EXPERIENCECANDIDATE".equals(role)) {
                        int expInYear = rs.getInt("exp_in_year");
                        String proSkill = rs.getString("pro_skill");
                        return new ExperienceCandidate(id, firstName, lastName, phone, email, password, expInYear, proSkill);
                    } else if ("FRESHERCANDIDATE".equals(role)) {
                        String graduationRank = rs.getString("graduation_rank");
                        return new FresherCandidate(id, firstName, lastName, phone, email, password, GraduationRank.valueOf(graduationRank));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean isUserExistsByEmail(String email) {
        String sql = "SELECT 1 FROM candidate WHERE email = ?;";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, email);
            try (ResultSet rs = statement.executeQuery()) {
                return rs.next();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
