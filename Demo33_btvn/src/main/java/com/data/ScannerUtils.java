package com.data;

import java.time.LocalDate;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;




import java.util.Scanner;

public class ScannerUtils {

    private static Scanner sc = new Scanner(System.in);
    public ScannerUtils(){

    }
    public static int inputInt(){
        while(true){
            try{
                return Integer.parseInt(sc.nextLine().trim());

            }catch (Exception var1){
                System.err.println("Nhập lại...");
            }
        }
    }
    public static Float inputFloat(){
        while(true){
            try {
                return Float.parseFloat(sc.next());

            }catch(Exception var1){
                System.err.println("Nhập lại...");
            }
        }
    }
    public static Double inputDouble(){
        while(true){
            try{
                return Double.parseDouble(sc.next());
            }catch(Exception var1){
                System.err.println("Nhập lại...");
            }
        }
    }
    public static int inputIntPositive(){
        while(true){
            try{
                int intPositive = Integer.parseInt(sc.nextLine());
                if(intPositive>0){
                    return intPositive;
                }
                System.err.println("Nhập lại...");
            }catch (Exception var1){
                System.err.println("Nhập lại...");
            }

        }
    }
    public static String inputString() {
        while (true) {
            String string = sc.nextLine().trim();
            if (!string.isEmpty()) {  // Nếu chuỗi không rỗng thì return
                return string;
            }
            System.err.println("Không được để trống! Nhập lại...");
        }
    }

    public static String inputPassword() {
        while (true) {
            String password = inputString();
            if (password.length() >= 6 && password.length() <= 12) {
                if (password.chars().anyMatch(Character::isUpperCase)) {
                    return password;
                }
                System.err.println("Mật khẩu phải có ít nhất 1 chữ hoa. Nhập lại...");
            } else {
                System.err.println("Mật khẩu phải từ 6-12 ký tự. Nhập lại...");
            }
        }
    }

    public static String inputEmail(){
        while (true) {

            String email = sc.nextLine();
            if(email != null && email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")){
                return email;
            }
            System.err.println("Nhập lại...");
        }

    }
    public static String inputFullName(){
        while(true){
            String fullName = inputString().trim();
            if(fullName.matches("^[a-zA-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐđĩũơưẠ-ỹ ]{3,25}$")){
                return fullName;
            }
            System.err.println("Họ tên không hợp lệ! Nhập lại...");
        }
    }

    public static int inputFunction(int a, int b){
        while(true){
            int number = inputInt();
            if (number >= a && number <= b) {
                return number;

            }
            System.err.println("Chỉ được nhập từ " + a + " đến " + b );
        }
    }
    public static String inputPhoneNumber(){
        System.out.println("Nhập vào số điện thoại");
        while(true){
            String number = inputString().trim();
            if (number.length() >= 9 && number.length() <= 15 && number.matches("^0[0-9]+$")) {
                return number;
            }
            System.err.println("Số điện thoại không hợp lệ! Nhập lại...");
        }
    }

    public static LocalDate inputLocalDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        while (true) {
            System.out.println("Nhập ngày (yyyy-MM-dd):");
            String input = sc.nextLine().trim();
            try {
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.err.println("Sai định dạng hoặc ngày không hợp lệ! Nhập lại...");
            }
        }
    }



}
