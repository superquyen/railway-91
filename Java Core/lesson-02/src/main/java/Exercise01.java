package com.vti.frontend;

import java.time.LocalDate;

import com.vti.entity.Account;
import com.vti.entity.Answer;
import com.vti.entity.CategoryQuestion;
import com.vti.entity.Department;
import com.vti.entity.Exam;
import com.vti.entity.ExamQuestion;
import com.vti.entity.Group;
import com.vti.entity.GroupAccount;
import com.vti.entity.Position;
import com.vti.entity.Position.PositionName;
import com.vti.entity.Question;
import com.vti.entity.TypeQuestion;
import com.vti.entity.TypeQuestion.TypeName;

public class Program {
    public static void main(String[] args) {
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Sale";

        Department dep2 = new Department();
        dep2.id = 2;
        dep2.name = "Maketing";

        Department dep3 = new Department();
        dep3.id = 3;
        dep3.name = "BOD";

        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = PositionName.Dev;

        Position pos2 = new Position();
        pos2.id = 2;
        pos2.name = PositionName.PM;

        Position pos3 = new Position();
        pos3.id = 3;
        pos3.name = PositionName.Scrum_Master;

        Account acc1 = new Account();
        acc1.id = 1;
        acc1.Email = "voquyen13320@gmail.com";
        acc1.UserName = "VoQuyen";
        acc1.FullName = "Vo Long Quyen";
        acc1.department = dep1;
        acc1.position = pos1;
        acc1.CreateDate = LocalDate.of(2021, 03, 17);

        Account acc2 = new Account();
        acc2.id = 2;
        acc2.Email = "HuongNguyen0607@gmail.com";
        acc2.UserName = "HuongNguyen";
        acc2.FullName = "Nguyen Thi Thu Huong";
        acc2.department = dep2;
        acc2.position = pos2;
        acc2.CreateDate = LocalDate.of(2022, 05, 13);

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.Email = "superquyen4952@gmail.com";
        acc3.UserName = "SPQ";
        acc3.FullName = "Super Quyen";
        acc3.department = dep3;
        acc3.position = pos3;
        acc3.CreateDate = LocalDate.now();

        Account acc4 = new Account();
        acc4.id = 4;
        acc4.Email = "super4952@gmail.com";
        acc4.UserName = "HAHAHA";
        acc4.FullName = "KAKAKA";
        acc4.department = dep3;
        acc4.position = pos3;
        acc4.CreateDate = LocalDate.now();

        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing System";
        group1.creator = acc1;
        group1.CreateDate = LocalDate.of(2021, 2, 13);
        Account[] group1Accs = { acc1, acc2 };
        group1.accounts = group1Accs;

        Group group2 = new Group();
        group2.id = 2;
        group2.name = "Development";
        group2.creator = acc3;
        group2.CreateDate = LocalDate.of(2023, 3, 22);
        Account[] group2Accs = { acc2, acc3 };
        group2.accounts = group2Accs;

        Group group3 = new Group();
        group3.id = 3;
        group3.name = "Sale";
        group3.creator = acc2;
        group3.CreateDate = LocalDate.of(2022, 5, 15);
        Account[] group3Accs = { acc1, acc3 };
        group3.accounts = group3Accs;

        // gan Group vao account
        Group[] acc1Groups = new Group[2];

        acc1Groups[0] = group1;
        acc1Groups[1] = group3;
        acc1.groups = acc1Groups;

        Group[] acc2Group = new Group[2];
        acc2Group[0] = group1;
        acc2Group[1] = group2;
        acc2.groups = acc2Group;

        Group[] acc3Group = { group2, group3 };
        acc3.groups = acc3Group;

        acc4.groups = new Group[] { group3 };

        GroupAccount grAcc1 = new GroupAccount();
        grAcc1.group = group1;
        grAcc1.account = acc1;
        grAcc1.joinDate = LocalDate.of(1999, 3, 2);

        TypeQuestion tyQuestion1 = new TypeQuestion();
        tyQuestion1.id = 1;
        tyQuestion1.name = TypeName.Essay;

        TypeQuestion tyQuestion2 = new TypeQuestion();
        tyQuestion2.id = 2;
        tyQuestion2.name = TypeName.Multiple_Choice;

        CategoryQuestion category1 = new CategoryQuestion();
        category1.id = 1;
        category1.name = "Java";
        CategoryQuestion category2 = new CategoryQuestion();
        category2.id = 2;
        category2.name = "SQL";
        CategoryQuestion category3 = new CategoryQuestion();
        category3.id = 3;
        category3.name = "Python";

        Question question1 = new Question();
        question1.id = 1;
        question1.content = " cau hoi ve Java";
        question1.category = category2;
        question1.typequestion = tyQuestion1;
        question1.creator = acc1;
        question1.createDate = LocalDate.of(2011, 3, 1);
        Question question2 = new Question();
        question2.id = 2;
        question2.content = " cau hoi ve python";
        question2.category = category1;
        question2.typequestion = tyQuestion2;
        question2.creator = acc3;
        question2.createDate = LocalDate.of(2021, 3, 1);
        Question question3 = new Question();
        question3.id = 3;
        question3.content = " cau hoi ve C#";
        question3.category = category3;
        question3.typequestion = tyQuestion1;
        question3.creator = acc2;
        question3.createDate = LocalDate.of(2010, 3, 1);

        Answer ans1 = new Answer();
        ans1.id = 1;
        ans1.content = "Tra loi 1";
        ans1.question = question1;
        ans1.isCorrect = true;
        Answer ans2 = new Answer();
        ans2.id = 2;
        ans2.content = "Tra loi 2";
        ans2.question = question3;
        ans2.isCorrect = false;
        Answer ans3 = new Answer();
        ans3.id = 3;
        ans3.content = "Tra loi 3";
        ans3.question = question2;
        ans3.isCorrect = true;

        Exam exam1 = new Exam();
        exam1.id = 1;
        exam1.code = "9108317";
        exam1.title = "De thi C#";
        exam1.category = category1;
        exam1.duration = 60;
        exam1.creator = acc2;
        exam1.createDate = LocalDate.of(1988, 2, 19);
        Exam exam2 = new Exam();
        exam2.id = 2;
        exam2.code = "VTI2960";
        exam2.title = "De thi AI";
        exam2.category = category2;
        exam2.duration = 100;
        exam2.creator = acc3;
        exam2.createDate = LocalDate.of(1988, 2, 19);
        Exam exam3 = new Exam();
        exam3.id = 3;
        exam3.code = "supercell";
        exam3.title = "De thi chatGPT";
        exam3.category = category3;
        exam3.duration = 120;
        exam3.creator = acc2;
        exam3.createDate = LocalDate.of(1988, 2, 19);

        ExamQuestion examques1 = new ExamQuestion();
        examques1.exam = exam2;
        examques1.question = question1;
        ExamQuestion examques2 = new ExamQuestion();
        examques1.exam = exam1;
        examques1.question = question3;
        ExamQuestion examques3 = new ExamQuestion();
        examques1.exam = exam3;
        examques1.question = question2;

        Answer[] ansQuestion1 = new Answer[2];
        ansQuestion1[0] = ans1;
        ansQuestion1[1] = ans2;

        Answer[] ansQuestion2 = { ans2, ans1 };
        // ans2.question = ansQuestion2;
        Answer[] ansQuestion3 = { ans3 };
        // System.out.println(" cau tra loi cho cau hoi 1: " + ansquestion1[0].content +
        // " , " + ansquestion1[1].content);

//		System.out.println("Thông tin các Account trên hệ thống: ");
//		System.out.println("Account 1 ");
//		System.out.println("ID: " + acc1.id);
//		System.out.println("Email: " + acc1.Email);
//		System.out.println("UserName: " + acc1.UserName);
//		System.out.println("Full Name: " + acc1.FullName);
//		System.out.println("Department:  " + acc1.department.name);
//		System.out.println("Position: " + acc1.position.name);
//		System.out.println("Group: " + acc1.groups[1].name + "," + acc1Groups[0].name);
//		System.out.println("GroupID: " + acc1Groups[1].id);
//		System.out.println("GroupID: " + acc3.groups[1].id);
//		System.out.println("group 4: " + acc4.groups[0].CreateDate);
        if (acc2.department == null) {
            System.out.println("Nhan vien nay chusa co phong ban");
        } else {
            System.out.println("phong ban cua nhan vien nay la: " + acc2.department.name);
        }

        if (acc2.groups == null) {
            System.out.println("Nhan vien nay chua co gruop");
        } else if (acc2Group.length == 1 || acc2Group.length == 2) {
            System.out.println("Group cua nha vien nay la Java Fresher, C# Fresher");
        } else if (acc2Group.length == 3) {
            System.out.println("Nhan vien nay la nguoi quan trong, tham gia nhieu group");
        } else if (acc2Group.length == 4) {
            System.out.println(" Nhan vien nay la nguoi hong chuyen, tham gia tat ca cac group");
        }

        System.out.println(acc2.department == null ? "Nhan vien nay chua co phong ban: "
                : "phong ban cua nhan vien nay la: " + acc2.department.name);
        System.out.println(acc1.position.name == PositionName.Dev ? "day la dev" : "Nguoi nay khong phai la Developer");

        switch (group1Accs.length) {
            case 1:
                System.out.println("nhom co mot thanh vien");
                break;
            case 2:
                System.out.println("nhom co hai thanh vien");
                break;
            case 3:
                System.out.println("nhom co ba thanh vien");
                break;
            default:
                System.out.println("nhom co nhieu thanh vien");
                break;
        }

        // Question 6:
        switch (acc2.groups.length) {
            case 0:
                System.out.println("Nhan vien nay chua co group");
                break;
            case 1:
            case 2:
                System.out.println("Group cua nhan vien nay la Java Fresher, C# Fresher");
                break;
            case 3:
                System.out.println(" Nhan vien nay la nguoi quan trong, tham gia nhieu Group");
                break;
            case 4:
                System.out.println(" Nhan vien nay la nguoi hong chuyen, tham gia tat ca group");
            default:
                System.out.println("nhom co nhieu thanh vien");
                break;
        }
        // question 7:
        switch (acc1.position.name.toString()) {
            case "Dev":
                System.out.println("Nguoi nay la Developer");
                break;

            default:
                System.out.println("Nguoi nay khong phai la developer");
                break;
        }

        // Question 8
        String[] allAcc = { acc1.Email, acc1.FullName, acc1.department.name, acc2.Email, acc2.FullName,
                acc2.department.name, acc3.Email, acc3.FullName, acc3.department.name };
        for (String tatacc : allAcc) {
            System.out.println(tatacc);
        }
        // giai
        Account[] accArray = { acc1, acc2, acc3 };
        for (Account account : accArray) {
            System.out.println("AccountID: " + account.id + " Email: " + account.Email + " Name: " + account.FullName);
        }
        Department[] depart = { dep1, dep2, dep3 };
        for (Department depp : depart) {
            System.out.println("Department ID: " + depp.id + " name : " + depp.name);
        }

        // question 10
        System.out.println("-------------------");
        Account[] thongTinAcc = { acc1, acc2 };

        for (int i = 0; i < thongTinAcc.length; i++) {
            System.out.println(" thong tin cua Account thu " + (i + 1) + " la:");
            System.out.println("Email: " + thongTinAcc[i].Email);
            System.out.println("Fullname: " + thongTinAcc[i].FullName);
            System.out.println("PHong ban: " + thongTinAcc[i].department.name);
        }
        // question 11
        Department[] phongBan = { dep1, dep2, dep3 };
        System.out.println(" thong tin department thu  1 la: ");
        for (int i = 0; i < phongBan.length; i++) {
            System.out.println("Thong tin cua department thu " + (i + 1) + " la: ");
            System.out.println("Thong tin ID: " + phongBan[i].id);
            System.out.println("ten Department: " + phongBan[i].name);

        }

        // Question 12

        System.out.println("-------------------");
        Account[] allAcc2 = { acc1, acc2, acc3 };
        for (int i = 0; i < allAcc2.length; i++) {
            if (allAcc2[i] == acc2) {
                continue;

            }
            System.out.println(" thong tin tai khoan " + (i + 1));
            System.out.println("AccountID: " + allAcc2[i].id);
            System.out.println("Name: " + allAcc2[i].FullName);
        }

        // Quesiton 15
        for (int i = 0; i < 21; i = i + 2) {
            System.out.println(i);
        }
        // hoac la
        for (int j = 0; j <= 20; j++) {
            if (j % 2 == 0) {
                System.out.println(j);
            }
        }
        // Question 16

        Account[] taiKhoan = { acc1, acc2, acc3 };
        int i = 0;
        while (i < taiKhoan.length) {
            System.out.println(" thong tin account thu " + (i + 1) + " la: ");
            System.out.println("Email: " + taiKhoan[i].Email);
            System.out.println("Full name: " + taiKhoan[i].FullName);
            System.out.println("Phong ban: " + taiKhoan[i].department.name);
            i++;
        }
        // tiep
        Department[] phongBan2 = { dep1, dep2, dep3 };
        int j = 0;
        while (j < phongBan2.length) {
            System.out.println("thong tin phong ban thu " + (j + 1) + " la :");
            System.out.println("Id : " + phongBan2[j].id);
            System.out.println("Name: " + phongBan2[j].name);
            j++;
        }

        // question 13.1
        System.out.println("-----Bai tap 13.1-----");
        Account[] taiKhoan2 = { acc1, acc2, acc3 };
        int k = 0;
        while (k < taiKhoan2.length) {
            if (taiKhoan2[k] != acc2) {
                System.out.println(" thong tin account thu " + (k + 1) + " la: ");
                System.out.println("Email: " + taiKhoan2[k].Email);
                System.out.println("Full name: " + taiKhoan2[k].FullName);
                System.out.println("Phong ban: " + taiKhoan2[k].department.name);
            }

            k++;
        }

        // question 14.1
        System.out.println("-----Bai tap 14.1-----");
        Account[] taiKhoan3 = { acc1, acc2, acc3 };
        int l = 0;
        while (l < taiKhoan3.length) {
            if (taiKhoan3[l].id < 4) {
                System.out.println(" thong tin account thu " + (l + 1) + " la: ");
                System.out.println("Email: " + taiKhoan3[l].Email);
                System.out.println("Full name: " + taiKhoan3[l].FullName);
                System.out.println("Phong ban: " + taiKhoan3[l].department.name);
            }

            l++;
        }
        // question 15.1
        int q = 0;
        while (q <= 20) {
            if (q % 2 == 0) {
                System.out.println(q);
            }
            q++;

        }
        // Question 10.2
        System.out.println("-----Bai tap 14.1-----");
        Account[] taiKhoan4 = { acc1, acc2, acc3 };
        int P = 0;
        do {
            if (taiKhoan4[P].id != 2) {
                System.out.println(" thong tin account thu " + (P + 1) + " la: ");
                System.out.println("Email: " + taiKhoan4[P].Email);
                System.out.println("Full name: " + taiKhoan4[P].FullName);
                System.out.println("Phong ban: " + taiKhoan4[P].department.name);

            }
            P++;
        } while (P < taiKhoan4.length);
        // Question 15.2
        int u = 0;
        do {
            if (u % 2 == 0) {
                System.out.println(u);
            }
            u++;
        } while (u <= 20);

    }
}
