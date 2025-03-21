package com.vti.backend.presentationlayer;


import com.vti.backend.businesslayer.CandidateService;
import com.vti.backend.businesslayer.ICandidateService;
import com.vti.entity.Candidate;
import com.vti.entity.GraduationRank;

import java.sql.SQLException;


public class CandidateController {
    private ICandidateService candidateService = new CandidateService();
    public CandidateController() throws SQLException {

    }


    public Candidate login(String email, String password) {
        return this.candidateService.login(email, password);
    }

    public boolean isUserExistsByEmail(String email) throws SQLException {
        return this.candidateService.isUserExistsByEmail(email);
    }

    public boolean registerE(String firstName, String lastName, String phone, String email, int expInYear, String proSkill, String password) throws SQLException {
        return this.candidateService.registerE(firstName, lastName, phone, email, expInYear, proSkill, password);
    }

    public boolean registerF(String firstName, String lastName, String phone, String email, GraduationRank graduationRank, String password) {
        return this.candidateService.registerF(firstName, lastName, phone, email, graduationRank, password);
    }
}
