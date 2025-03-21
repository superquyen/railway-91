package com.vti.backend.businesslayer;

import com.vti.backend.datalayer.CandidateRepository;
import com.vti.backend.datalayer.ICandidateRepository;
import com.vti.entity.Candidate;
import com.vti.entity.GraduationRank;

import java.sql.SQLException;

public class CandidateService implements ICandidateService {
    private ICandidateRepository candidateRepository = new CandidateRepository();

    public CandidateService() throws SQLException {
    }

    public boolean registerE(String firstName, String lastName, String phone, String email, int expInYear, String proSkill, String password) throws SQLException {
        return this.candidateRepository.registerE(firstName, lastName, phone, email, expInYear, proSkill, password);
    }

    @Override
    public boolean registerF(String var1, String var2, String var3, String var4, GraduationRank var5, String var6) {
        return false;
    }

    public boolean registerF(String firstName, String lastName, String phone, String email, String password, GraduationRank graduationRank) {
        // Sửa lại thứ tự tham số cho đúng với ICandidateRepository
        return this.candidateRepository.registerF(firstName, lastName, phone, email, password, graduationRank);
    }

    public Candidate login(String email, String password) {
        return this.candidateRepository.login(email, password);
    }

    public boolean isUserExistsByEmail(String email) throws SQLException {
        return this.candidateRepository.isUserExistsByEmail(email);
    }
}
