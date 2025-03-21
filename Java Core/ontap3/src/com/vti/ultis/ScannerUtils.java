package com.vti.ultis;

import com.mysql.cj.util.StringUtils;

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
    public static String inputString(){
        while(true){
            String string = sc.nextLine();
            if(!StringUtils.isNullOrEmpty(string)){
                return  string;
            }
            System.err.println("Nhập lại...");
        }
    }
    public static String inputPassword() {
        while (true) {
            String password = inputString();
            if (password.length() >= 6 && password.length() <= 12) {
                boolean hasAtLeast1Character = false;
                for(int i = 0; i < password.length(); i++){
                    if(Character.isUpperCase(password.charAt(i))){
                        hasAtLeast1Character = true;
                        break;
                    }
                }
                if (hasAtLeast1Character) {

                    return password;
                }
                System.err.println("Mời bạn nhập lại password: ");

            }else{
                System.err.println("Nhập lại...");
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
            String fullName = inputString();
            if(fullName != null && fullName.matches("^[aAàÀảẢãÃáÁạẠăĂằẰẳẲẵẴắẮặẶâÂầẦẩẨẫẪấẤậẬbBcCdDđĐeEèÈẻẺẽẼéÉẹẸêÊềỀểỂễỄếẾệỆfFgGhHiIìÌỉỈĩĨíÍịỊjJkKlLmMnNoOòÒỏỎõÕóÓọỌôÔồỒổỔỗỖốỐộỘơƠờỜởỞỡỠớỚợỢpPqQrRsStTuUùÙủỦũŨúÚụỤưƯừỪửỬữỮứỨựỰvVwWxXyYỳỲỷỶỹỸýÝỵỴzZ \\\\ _-]{3,25}$"))
            {
                return fullName;

            }
            System.err.println("Nhập lại...");

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
    public static String inputPhongNumber(){
        System.out.println("Nhập vào số điện thoại");
        while(true){
            boolean isNumber = true;
            String number = inputString();
            if(number.charAt(0) != '0'){
                isNumber = false;
            }
            for(int i = 0; i < number.length(); i++){
                if(!Character.isDigit(number.charAt(i))){
                    isNumber = false;
                    break;
                }
            }
            if (isNumber) {

                return number;
            }
            System.err.println("Nhập lại...");
        }
    }


}
