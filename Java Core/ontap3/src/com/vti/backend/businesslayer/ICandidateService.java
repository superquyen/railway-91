package com.vti.backend.businesslayer;

import com.vti.entity.Candidate;
import com.vti.entity.GraduationRank;

import java.sql.SQLException;

public interface ICandidateService {

    Candidate login(String var1, String var2) ;

    boolean isUserExistsByEmail(String var1) throws SQLException;

    boolean registerE(String var1, String var2, String var3, String var4, int var5, String var6, String var7) throws SQLException;

    boolean registerF(String var1, String var2, String var3, String var4, GraduationRank var5, String var6) ;
}
