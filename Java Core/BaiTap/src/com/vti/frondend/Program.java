package com.vti.frondend;

import com.vti.backend.BaiTap;

import java.awt.*;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Program program = new Program();
        program.Menu();
        Scanner sc = new Scanner(System.in);
        BaiTap baiTap = new BaiTap();
        while (true) {

            int choose = sc.nextInt();

            switch (choose) {
                case 1:
                    baiTap.ThemSv();
                    break;
                case 2:
                    baiTap.InSv();
                    break;
                case 3:
                    baiTap.TimSv();
                    break;
                case 4:
                    program.Menu();
                    break;
                case 5:
                    System.out.println("Kết thúc chương trình");
                    return;
                default:
                    break;
            }
        }

    }
    public void Menu(){
            System.out.println("+========Chương trình quản lý sinh viên============");
            System.out.printf("|%-49s|%n", "Mời chọn chức năng tương ứng: 1, 2, 3, 4, 5***");
            System.out.printf("|%-49s|%n", "1. thêm mới sinh viên");
            System.out.printf("|%-49s|%n", "2. Hiển thị danh sách tất cả các sinh viên");
            System.out.printf("|%-49s|%n", "3. Tìm kiếm sinh viên theo tên");
            System.out.printf("|%-49s|%n", "4. Quay lại Menu");
            System.out.printf("|%-49s|%n", "5. Thoát");
            System.out.println("===================================================");
        }
    }

