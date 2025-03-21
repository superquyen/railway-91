package com.vti.frontend;

import com.vti.backend.presentationlayer.CandidateController;
import com.vti.entity.Candidate;
import com.vti.entity.GraduationRank;
import com.vti.ultis.ScannerUtils;

import java.sql.SQLException;
import java.util.Scanner;

public class Function {
    private CandidateController candidateController;
    Scanner scanner;

    public Function() throws SQLException {
        this.scanner = new Scanner(System.in);
        this.candidateController = new CandidateController();
    }

    public void login() {
        while (true) {
            System.out.println("Mời bạn nhập Email của account: ");
            String email = ScannerUtils.inputEmail();
            System.out.println("Mời bạn nhập Password: ");
            String password = ScannerUtils.inputPassword();
            Candidate candidate = this.candidateController.login(email, password);
            if (candidate != null) {

                System.out.printf("Chào mừng %s(%s) \n \n \n", candidate.getFirstName() + " " + candidate.getLastName(), candidate.getRole());
            }
            System.err.println("Email hoặc Passwprd không đúng! mời bạn đăng nhập lại");
        }
    }

    public void addExperienceCandidate() throws SQLException {
        System.out.println("Mời bạn nhập firstname: ");
        String firstName = this.scanner.nextLine();
        System.out.println("Mời bạn nhập lastname: ");
        String lastName = this.scanner.nextLine();
        String phone = ScannerUtils.inputPhongNumber();
        System.out.println("Mời bạn nhập password: ");
        String password = ScannerUtils.inputPassword();
        System.out.println("Mời bạn nhập năm kinh nghiệm: ");
        int expInYear = ScannerUtils.inputFunction(0, 10);
        System.out.println("Mời bạn nhập ProSkill: ");
        String proSkill = this.scanner.nextLine();
        System.out.println("Mời bạn nhập Email: ");
        String email = "";
        while (true) {
            email = ScannerUtils.inputEmail();
            boolean resultExistsEmail = this.candidateController.isUserExistsByEmail(email);
            if (!resultExistsEmail) {
                resultExistsEmail = this.candidateController.registerE(firstName, lastName, phone, email, expInYear, proSkill, password);
                if (resultExistsEmail) {
                    System.out.println("Tạo mới ExperienceCandidate thành công");
                } else {
                    System.out.println("Tạo mới ExperienceCandidate không thành công");
                }
                return;
            }
            System.err.println("Email" + email + "đã tồn tại ! mời nhập email khác");
        }

    }
    public void addFresherCandidate() throws SQLException {
        System.out.println("Mời bạn nhập firstname: ");
        String firstName = this.scanner.nextLine();
        System.out.println("Mời bạn nhập lastname: ");
        String lastName = this.scanner.nextLine();
        String phone = ScannerUtils.inputPhongNumber();
        System.out.println("Mời bạn nhập password: ");
        String password = ScannerUtils.inputPassword();
        System.out.println("Mời bạn nhập GraduationRank: 1. Excellence, 2.Good, 3.Fair, khác: Poor");
        int key = this.scanner.nextInt();
        GraduationRank graduationRank;
        switch (key){
            case 1:
                graduationRank = GraduationRank.EXCELLENCE;
            break;
            case 2:
                graduationRank = GraduationRank.GOOD;
                break;
            case 3:
                graduationRank = GraduationRank.FAIR;
                break;
            default:
                graduationRank = GraduationRank.POOR;
                break;



        }
        System.out.println("mời bạn nhập vào Email: ");
        while(true){
            String email = ScannerUtils.inputEmail();
            boolean resultExistsEmail = this.candidateController.isUserExistsByEmail(email);
            if (!resultExistsEmail) {
                resultExistsEmail = this.candidateController.registerF(firstName, lastName, phone, email, graduationRank, password);
                if(resultExistsEmail){
                System.out.println("Tạo mới FresherCandidate thành công");
            }else {
                    System.out.println("Tạo mới FresherCandidate thất bại");
                }
                return;
            }
            System.err.println("Email" + email + "đã tồn tại ! mời nhập email khác");



        }

    }


}

