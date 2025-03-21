package com.vti.backend.datalayer;

import com.vti.entity.Candidate;
import com.vti.entity.GraduationRank;

import java.sql.SQLException;

public interface ICandidateRepository {
    boolean registerE(String firstName, String lastName, String phone, String email, int expInYear, String proSkill, String password) throws SQLException;

    boolean isUserExistsByEmail(String email) throws SQLException;

    Candidate login(String email, String password);

    boolean registerF(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank);
}
