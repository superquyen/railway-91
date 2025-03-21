package com.vti.frontend;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    public static boolean islogin = false;
    public Main() {
    }
    public static void main(String[] args) throws SQLException {
        register();
        }
    public static void register() throws SQLException {
        Function function = new Function();
        System.out.println("Mời bạn đăng ký: ");
        System.out.println("1. Đăng ký ExperienceCandidate");
        System.out.println("2. Đăng ký FreshCandidate");
        int n = scanner.nextInt();
        switch (n){
            case 1:
                function.addExperienceCandidate();
                break;
            case 2:
                function.addFresherCandidate();
                break;
        }
        System.out.println("Mời bạn đăng nhập: ");
        function.login();
    }

}
